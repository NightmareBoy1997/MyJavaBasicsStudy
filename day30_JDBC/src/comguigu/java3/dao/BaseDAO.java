package comguigu.java3.dao;

import comguigu.java.demo.java3.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.java3
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-11 20:31
 * <p>
 * <p>
 *  DAO : data(base) access object
 * 封装了针对数据表的通用的操作；
 */
public abstract class BaseDAO {

    /**
     * 通用的增删改操作 version 2.0 考虑上事务
     *
     * @return
     */
    public int update(Connection connection, String sql, Object... objects) {
        // 预编译sql语句，返回PreparedStatement的实例
        PreparedStatement preparedStatement = null;
        int number = 0;
        try {
            final int length = objects.length;
            preparedStatement = connection.prepareStatement(sql);
            // 2. 填充占位符
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            // 3. 执行
            number = preparedStatement.executeUpdate();
            return number;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, preparedStatement);
        }
        return 0;
    }


    /**
     * 通用的查询单条记录对象的操作
     *
     * @param connection
     * @param T
     * @param sql
     * @param objects
     * @param <T>
     * @return
     */
    public <T> T getInstance(Connection connection, Class<T> T, String sql, Object... objects) {

        final int length = objects.length;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. 执行预编译指令
            preparedStatement = connection.prepareStatement(sql);

            // 2. 给占位符赋值
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            // 3. 执行查询获取结果集
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // 4. 新建对应的类对象
                T t = T.newInstance();
                final ResultSetMetaData metaData = preparedStatement.getMetaData();
                final int columnCount = metaData.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    final Object columnValue = resultSet.getObject(i + 1);
                    final String columnLabel = metaData.getColumnLabel(i + 1);
                    final Field field = T.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBCUtils.closeResource(null, preparedStatement, resultSet);
        return null;
    }

    /**
     * 查询获取数据表的多条记录的对象集合的操作
     *
     * @param connection
     * @param T
     * @param sql
     * @param objects
     * @param <T>
     * @return
     */
    public <T> List<T> getInstanceList(Connection connection, Class<T> T, String sql, Object... objects) {
        final int length = objects.length;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            resultSet = preparedStatement.executeQuery();
            final ResultSetMetaData metaData = resultSet.getMetaData();
            ArrayList<T> list = new ArrayList(10);

            while (resultSet.next()) {
                final T t = T.newInstance();
                final int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    final Object columnValue = resultSet.getObject(i);
                    final String columnLabel = metaData.getColumnLabel(i);
                    final Field field = T.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, preparedStatement, resultSet);
        }
        return null;
    }


    /**
     * 获取非增删改查(组函数等)的值
     * @param connection
     * @param sql
     * @param objects
     * @param <E>
     * @return
     */
    public <E> E getValue(Connection connection, String sql, Object... objects) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (E) resultSet.getObject(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, preparedStatement, resultSet);
        }
        return null;
    }


}