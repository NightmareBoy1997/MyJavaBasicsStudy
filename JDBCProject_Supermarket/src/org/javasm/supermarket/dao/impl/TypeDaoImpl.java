package org.javasm.supermarket.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.javasm.supermarket.bean.Type;
import org.javasm.supermarket.dao.TypeDao;
import org.javasm.supermarket.sql.TypeSql;
import org.javasm.supermarket.util.DruidUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 11:29
 */
public class TypeDaoImpl implements TypeDao {
    // 需要传入connection，以及手动关闭connection资源
    static QueryRunner queryRunner = new QueryRunner();

    /**
     *  根据对象增加或修改数据库中的一条记录
     * @param connection
     * @param type
     * @return
     */
    public int updateTypeById(Connection connection, Type type) throws SQLException {
        Integer id = type.getId();
        int number ;

        if(id==null){
            number = queryRunner.update(connection,TypeSql.INSERT_TYPE,type.getPrentId(),type.getTypeName()) ;
        }else{
            int typePrent = ( type.isPrent() )? 1 : 0;
            int typeStatus = ( type.isTypeStatus() ) ? 1 : 0;
//            Type typeNameQuery = queryRunner.query(connection, TypeSql.SELECT_TYPE_BY_ID, new BeanHandler<>(Type.class) );
            number =  queryRunner.update( connection,TypeSql.UPDATE_TYPE_BY_ID,type.getPrentId(),type.getTypeName(),
                    typePrent,typeStatus , type.getId() );
        }
        return number;
    }

    @Override
    public List<Type> findAllType(Connection connection ) throws SQLException {
        final List<Type> typeList = queryRunner.query(connection, TypeSql.SELECT_ALL_TYPE, new BeanListHandler<>(Type.class));
        return typeList ;
    }

    @Override
    public Type findTypeById(Connection connection ,int typeId) throws SQLException {
        Type type = queryRunner.query(connection, TypeSql.SELECT_TYPE_BY_ID, new BeanHandler<>(Type.class),typeId);
        return type ;
    }

    @Override
    public boolean deleteTypeById(Connection connection , int typeId) throws SQLException {
        int update = queryRunner.update(connection, TypeSql.DELETE_TYPE_BY_ID, typeId);
        return true;
    }


    @Test
    public void test(){
        try {
            findAllType(DruidUtil.getConnection()).stream().forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}