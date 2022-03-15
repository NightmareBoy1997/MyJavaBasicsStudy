package com.javasm.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @projectName: JDBC
 * @package: study.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-11 14:37
 */
public class Utils {

    public static Properties properties = null;

    /**
     * 给properties赋值
     */
    static {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private Utils() {
    }


    /**
     * properties 获取 Connection 实例
     */
    public static Connection getConnection() {
        try {

            final String url = (String) properties.get("url");
            final String user = (String) properties.get("user");
            String password = (String) properties.get("password");
            String driverClass = (String) properties.get("driverClass");

            Class.forName(driverClass);

            final Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  获取preparedStatement实例的方法
     * @param sql
     * @return
     * @throws SQLException
     */
    public static PreparedStatement getPreparedStatement(Connection connection , String sql , Object...objects) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if(objects != null){
            final int length = objects.length;
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
        }
        return preparedStatement;
    }

    /**
     *  增删改操作
     * @param sql
     * @param objects
     */
    public static void update(String sql, Object... objects) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        final int length = objects.length;
        int number = 0;

        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            number = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (number > 0) {
                System.out.println("修改成功!");
            } else {
                System.out.println("修改失败！");
            }
            closeResource(connection, preparedStatement,null);
        }
    }


    /**
     *  资源关闭
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    /**
     *  查询其他类型（组函数...）的值
     * @param sql
     * @param objects
     * @param <T>
     * @return
     * @throws SQLException
     */
    public static <T> T getValue(String sql , Object... objects) throws SQLException {
        final PreparedStatement preparedStatement = Utils.getPreparedStatement(Utils.getConnection(), sql, objects);
        final ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return (T)resultSet.getObject(1);
        }
        return null;
    }



}