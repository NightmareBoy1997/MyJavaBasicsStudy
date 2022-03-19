package org.javasm.supermarket.server.impl;

import org.apache.commons.dbutils.DbUtils;
import org.javasm.supermarket.bean.Product;
import org.javasm.supermarket.bean.Type;
import org.javasm.supermarket.dao.ProductDao;
import org.javasm.supermarket.dao.TypeDao;
import org.javasm.supermarket.dao.impl.ProductDaoImpl;
import org.javasm.supermarket.dao.impl.TypeDaoImpl;
import org.javasm.supermarket.server.TypeService;
import org.javasm.supermarket.util.DruidUtil;
import org.javasm.supermarket.util.QueryCacheUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.server.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 15:07
 */
public class TypeServiceImpl implements TypeService {
    private static final TypeDao typeDao = new TypeDaoImpl();
    private static final ProductDao productDao = new ProductDaoImpl();

    // 获取全部的商品类型缓存集
    private static List<Type> allTypeList = QueryCacheUtil.getAllCacheList(Type.class);

    @Override
    public void findAllType() {
        String str = "|- ";
        for (Type type : allTypeList) {
            if (type.getPrentId().equals(0)) {
                System.out.println(str + type.getId() + " : " + type.getTypeName());
                // 找指定父类型的子级类型
                findChildType(type, "| " + str, allTypeList);
            }
        }
    }


    @Override
    public boolean addType(Type type) {
        Connection connection = null;
        boolean flag = true;

        try {
            connection = DruidUtil.getConnection();
            connection.setAutoCommit(false);

            Integer prentId = type.getPrentId();
            if (!prentId.equals(0)) {
                flag = setNewPrentType(connection, prentId);
            }
            if (!flag) {
                return false;
            }

            typeDao.updateTypeById(connection, type);
            connection.commit();
            connection.setAutoCommit(true);

            // 更新缓存
            allTypeList = typeDao.findAllType(connection);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return true;
    }


    @Override
    public boolean updateType(Type type) {
        Connection connection = DruidUtil.getConnection();
        int id = type.getId();
        final Integer newPrentId = type.getPrentId();
        final String newTypeName = type.getTypeName();
        boolean succeed;

        try {
            Type updateType = typeDao.findTypeById(connection, id);
            connection.setAutoCommit(false);

            if (Objects.nonNull(newPrentId)) {
                // 判断是否需要更新要关联的父级类型的父级状态
                succeed = setNewPrentType(connection, newPrentId);

                if (!succeed) {
                    return false;
                }

                // 判断是否需要更新之前父类的父级状态
                final Integer oldPrentId = updateType.getPrentId();
                setOldPrentType(connection, oldPrentId);

                updateType.setPrentId(newPrentId);
            }
            if (Objects.nonNull(newTypeName)) {
                updateType.setTypeName(newTypeName);
            }

            // 执行修改
            typeDao.updateTypeById(connection, updateType);
            connection.commit();
            connection.setAutoCommit(true);

            // 更新缓存
            allTypeList = typeDao.findAllType(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            // 如果出现异常，回滚事务
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return true;
    }


    @Override
    public boolean deleteType(int typeId) {
        List<Type> typeList = allTypeList.stream().filter(t -> t.getId().equals(typeId)).collect(Collectors.toList());
        if (typeList.isEmpty()) {
            System.out.println("要删除的类型不存在！");
            return false;
        }
        Type type = typeList.get(0);
        Connection connection = DruidUtil.getConnection();

        final String typeName = type.getTypeName();

        // 作为父级类型 不能删除
        if (type.isPrent()) {
            System.out.println("<<" + typeName + ">> 是作为父级类型，无法删除！");
            return false;
        }

        try {
            // 删除子级类型： 1.没有商品关联 可以删除  2. 有商品关联 无法删除
            // 查询是否有商品使用此类型
            List<Product> productList = productDao.findProductByTypeId(connection, typeId);
            if (!productList.isEmpty()) {
                System.out.println("<<" + typeName + ">> 关联了具体商品，无法删除！");
                return false;
            }
            connection.setAutoCommit(false);

            // 执行操作
            typeDao.deleteTypeById(connection , typeId);
            //  判断是否需要更新之前父类的父级状态
            setOldPrentType(connection ,type.getPrentId());
            // 更新缓存
            allTypeList = typeDao.findAllType(connection);

            // 改回设置
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return true;
    }


    /**
     * 判断要关联的父级类型的isPrent状态是否需要更新
     *
     * @param connection
     * @param newPrentId 要关联的父级类型id
     * @throws SQLException
     */
    private boolean setNewPrentType(Connection connection, int newPrentId) throws SQLException {
        // 查看要关联的父类是否存在
        Type newPrentType = typeDao.findTypeById(connection, newPrentId);
        if (newPrentType == null) {
            System.out.println("要关联的父级类型不存在,操作失败!");
            return false;
        }
        // 如果新的父级类型的prent不是父级类型( prent = false )，修改其值
        if (!newPrentType.isPrent()) {
            newPrentType.setPrent(true);
            typeDao.updateTypeById(connection, newPrentType);
        }
        return true;
    }


    /**
     * 判断是否需要更新之前父类的父级状态
     *
     * @param connection
     * @param oldPrentId 旧的的父级类型id
     * @throws SQLException
     */
    public void setOldPrentType(Connection connection, int oldPrentId) throws SQLException {
        List<Type> oldPrentList = allTypeList.stream().filter(t -> t.getPrentId().equals(oldPrentId)).collect(Collectors.toList());
        // 查看旧父级类型是否存在其他子级类型，如果没有修改prent值
        if (oldPrentList.size() <= 1) {
            Type oldPrentIdType = typeDao.findTypeById(connection, oldPrentId);
            oldPrentIdType.setPrent(false);
            typeDao.updateTypeById(connection, oldPrentIdType);
        }
    }


    /**
     * 获取子级商品类型类目
     *
     * @param parenType
     * @param str
     * @param typeList
     */
    private void findChildType(Type parenType, String str, List<Type> typeList) {
        final Integer id = parenType.getId();
        for (Type type : typeList) {
            if (type.getPrentId().equals(id)) {
                System.out.println(str + type.getId() + " ： " + type.getTypeName());
                // 如果其下的子级类型也是父级类型
                if (type.isPrent())
                    findChildType(type, "| " + str, typeList);
            }
        }


    }


    /**
     * 查看属性id类型数据是否存在
     *
     * @param id
     * @return
     */
    private Type findListType(int id) {
        List<Type> list = allTypeList.stream().filter(t -> t.getId().equals(id)).collect(Collectors.toList());
        if (list.isEmpty()) {
            System.out.println("没有此商品类型!");
            return null;
        }
        // 由于id唯一性，存在就代表只有一个元素就是此类型
        return list.get(0);
    }


}