package org.javasm.supermarket.util;

import org.apache.commons.dbutils.DbUtils;
import org.javasm.supermarket.bean.Type;
import org.javasm.supermarket.dao.MemberDao;
import org.javasm.supermarket.dao.ProductDao;
import org.javasm.supermarket.dao.TypeDao;
import org.javasm.supermarket.dao.impl.MemberDaoImpl;
import org.javasm.supermarket.dao.impl.ProductDaoImpl;
import org.javasm.supermarket.dao.impl.TypeDaoImpl;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 11:31
 * <p>
 * <p>
 * //缓存的思想: 类型的数据  一般都不变  每次查询数据库 性能比较低的
 * //一般不变的数据  其实可以存储在内存/缓存
 * //查询数据----> 从缓存去查询
 * //1. 有  直接操作缓存的数据
 * //2. 没有 从数据库查询 并存储缓存
 * <p>
 * //优点: 提高了查询的性能
 * //缺点: 更新了  缓存是不知道的  不能实时同步
 * //更新了---->更改缓存的数据
 * //通过缓存获得存储的数据----> 缓存可以存储很多的数据----> 容器 Map
 */
public abstract class CacheUtil {
    static Map<Class<?>, List<?>> cacheMap = new HashMap(16);
    static TypeDao typeDao = new TypeDaoImpl();
    static ProductDao productDao = new ProductDaoImpl();
    static MemberDao memberDao = new MemberDaoImpl();

    /**
     * 获取商品类型缓存
     */
    public static <T> List<T> getAllCacheList(Class<T> clazz) {
        // 如果此类型数据缓存不存在，初始化
        if (!cacheMap.containsKey(clazz)) {
            updateFunction(clazz);
        }
        return (List<T>) cacheMap.get(clazz);
    }


    /**
     * 初始化和更新缓存功能
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> void updateFunction(Class<T> clazz) {
        Connection connection = DruidUtil.getConnection();
        List<T> list ;
        String str = clazz.toString();
        final String classString = str.substring(str.lastIndexOf(".") + 1);
        try {
            switch (classString) {
                case "Type":
                    list = (List<T>) typeDao.findAllType(connection);
                    break;
                case "Product":
                    list = (List<T>) productDao.findAll(connection);
                    break;
                case "Member":
                    list = (List<T>) memberDao.findAll();
                    break;
                default:
                    throw new RuntimeException("不存在此类型数据缓存!");
            }
            cacheMap.put(clazz, list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }
    }


    public static void updateCache(Class<?> clazz) {
        if (!cacheMap.containsKey(clazz)) {
            throw new RuntimeException("不存在此类型的数据缓存！");
        }
        updateFunction(clazz);
    }


    @Test
    public void test() {
        try {
            getAllCacheList(Type.class).stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}