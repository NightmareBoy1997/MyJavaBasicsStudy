package org.javasm.supermarket.dao;

import org.javasm.supermarket.bean.Type;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 11:28
 */
public interface TypeDao {

//    void addType(Type type);

    int updateTypeById(Connection connection , Type type) throws SQLException;

    /**
     * 显式所有类型的信息
     */
    List<Type> findAllType(Connection connection ) throws SQLException;


    Type findTypeById(Connection connection , int typeId) throws SQLException;

    boolean deleteTypeById(Connection connection ,int typeId) throws SQLException;

}