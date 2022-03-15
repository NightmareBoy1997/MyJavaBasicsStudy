package com.javasm.demo3.dao;

import com.javasm.demo3.util.UtilRelevance;
import com.javasm.util.Utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 17:25
 */
public class BaseDao<T> {

        /**
         *  增删改的基本通用操作
         * @param connection
         * @param sql
         * @param objects
         * @throws Exception
         */
        public void update(Connection connection , String sql , Object...objects ) {
            final int number = UtilRelevance.update(connection, sql, objects);

            if(number > 0){
                System.out.println("操作成功！影响了 " + number +" 条记录");
            }else {
                System.out.println("操作失败！影响了 " + number +" 条记录");
            }
        }


        /** 查询全部记录
         *
         * @param sql
         * @return
         * @throws Exception
         */
        public List<T> queryAllInstanceList(Class<T> clazz , String sql) {
            List<T> list = new ArrayList(10);

            Connection connection = null;
            PreparedStatement preparedStatement =null;

            ResultSet resultSet = null;

            try {
                connection = UtilRelevance.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    final T t = clazz.getDeclaredConstructor().newInstance();
                    final ResultSetMetaData metaData = resultSet.getMetaData();
                    final int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        final String columnLabel = metaData.getColumnLabel(i);
                        final Object columnValue = resultSet.getObject(i);
                        final Field field = clazz.getDeclaredField(columnLabel);
                        field.setAccessible(true) ;
                        field.set(t,columnValue);
                    }
                    list.add(t);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                UtilRelevance.closeResource(connection , preparedStatement,resultSet);
            }

            return list;

        }


    /**
     *  查询特殊值
     * @param sql
     * @return
     */
        public Integer getTableValue(String sql){
            Connection connection = null ;
            PreparedStatement preparedStatement = null ;
            ResultSet resultSet = null ;
            try {
                connection = Utils.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    return resultSet.getInt(1);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                UtilRelevance.closeResource(connection,preparedStatement,resultSet);
            }
            return null;
        }

}
