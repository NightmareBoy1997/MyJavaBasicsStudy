package com.javasm.demo2.dao;

import com.javasm.util.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo2.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-14 16:52
 */
public abstract class BaseDao<T> {

    Class<T> clazz;

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];
    }


    /**
     * 增删改操作
     *
     * @param connection
     * @param sql
     * @param objects
     * @return
     * @throws SQLException
     */
    public int update(Connection connection, String sql, Object... objects){
        int updateNumber = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Utils.getPreparedStatement(connection, sql, objects);
            updateNumber = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Utils.closeResource(null,preparedStatement,null);
        }
        return updateNumber;
    }


    /**
     *  根据id查询数据表中的一条记录
     * @param sql
     * @param id
     * @return
     * @throws Exception
     */
    public T getInstanceById(String sql, int id){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = Utils.getPreparedStatement(Utils.getConnection(),sql,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                T t = clazz.newInstance();
                getExecute(resultSet, t);
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(null,preparedStatement,resultSet);
        }
        return null;
    }

    public void getExecute(ResultSet resultSet, T t) throws SQLException, NoSuchFieldException, IllegalAccessException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String columnLabel = metaData.getColumnLabel(i);
            Object columnValue = resultSet.getObject(i);
            Field field = clazz.getDeclaredField(columnLabel);
            field.setAccessible(true);
            field.set(t, columnValue);
        }
    }


    /**
     * 根据给定条件查询数据表中多条记录的集合
     * @param sql
     * @return
     */
    public List<T> getInstanceList(String sql , Object...objects){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = null;

        try {
            preparedStatement = Utils.getPreparedStatement(Utils.getConnection(),sql,objects);
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>(10);

            while(resultSet.next()){
                T t = clazz.newInstance();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Object columnValue = resultSet.getObject(i);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(null,preparedStatement,resultSet);
        }
        return list;
    }


    /**
     *     根据给定preparedStatement条件查询数据表中多条记录的集合
     * @param preparedStatement
     * @return
     */
    public List<T> getInstanceList(PreparedStatement preparedStatement ){
        ResultSet resultSet = null;
        List<T> list = null;

        try {
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>(10);

            while(resultSet.next()){
                T t = clazz.newInstance();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Object columnValue = resultSet.getObject(i);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(null,preparedStatement,resultSet);
        }
        return list;
    }


    /**
     * 根据给定条件查询数据表中多条记录的集合
     * @param sql
     * @return
     */
    public List<T> getInstanceLimitList(String sql , int id){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = null;

        try {
            preparedStatement = Utils.getPreparedStatement(Utils.getConnection(),sql,id);
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>(10);

            while(resultSet.next()){
                T t = clazz.newInstance();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Object columnValue = resultSet.getObject(i);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(null,preparedStatement,resultSet);
        }
        return list;
    }


    /**
     *  获取数据表里的所有记录的对象集合
     * @param sql
     * @return
     * @throws Exception
     */
    public List<T> getAllInstance(String sql){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = null;

        try {
            preparedStatement = Utils.getPreparedStatement(Utils.getConnection(),sql);
            resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>(10);

            while(resultSet.next()){
                T t = clazz.newInstance();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Object columnValue = resultSet.getObject(i);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(null,preparedStatement,resultSet);
        }
        return list;
    }


    /**
     *  获取结果集
     * @param preparedStatement
     * @return
     * @throws Exception
     */
    public List<T> getInstance(PreparedStatement preparedStatement) throws Exception {

        ResultSet resultSet = preparedStatement.executeQuery();
        List<T> list= new ArrayList<>(10);

        while(resultSet.next()){
            T t = clazz.newInstance();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i);
                Object columnValue = resultSet.getObject(i);
                Field field = clazz.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            list.add(t);
        }
        return list;
    }



    /**
     *  获取 组函数等特殊值
     * @param sql
     * @param objects
     * @param <T>
     * @return
     */
    public <T> T getValue(String sql , Object...objects){
        try {
            T value =(T) Utils.getValue(sql,objects);
            return value;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}