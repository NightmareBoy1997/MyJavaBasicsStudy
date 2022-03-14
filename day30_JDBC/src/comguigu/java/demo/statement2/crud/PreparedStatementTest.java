package comguigu.java.demo.statement2.crud;

import comguigu.java.demo.java3.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Scanner;

/**
 * @projectName: JDBC
 * @package: comguigu.statement2.crud
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-08 15:40
 *
 *  PreparedStatement解决SQL注入问题
 *  除了解决Statement的拼串、sql注入问题之外，PreparedStatement还有哪些好处？
 *   1. PreparedStatement还可以操作Blob的数据
 *   2. PreparedStatement可以实现高效的批量加入
 *
 */
public class PreparedStatementTest {

    // 使用Statement的弊端：需要拼写sql语句，并且存在SQL注入的问题
    // 如何避免sql注入： 只要用PreparedStatement(从Statement扩展而来)取代Statement
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("用户名：");
        String userName = scan.nextLine();
        System.out.print("密   码：");
        String password = scan.nextLine();

        // SELECT user,password FROM user_table WHERE USER = '1' or ' AND PASSWORD = '
        // ='1' or '1' = '1';
        String sql = "SELECT user,password FROM user_table WHERE USER = ? AND PASSWORD = ? ";
        User user = dataQueryNewInstance( User.class,sql,userName,password);
        if (user != null) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("用户名或密码错误！");
        }

    }

    /**
     * 使用preparedStatement实现表的通用查询操作
     *
     * @param eClass
     * @param sql
     * @param objects
     * @param <E>
     */
    public static <E> E dataQueryNewInstance(Class<E> eClass, String sql, Object... objects) {
        ResultSet resultSet = null;

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            int length = objects.length;
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = preparedStatement.getMetaData();

            int columnCount = metaData.getColumnCount();
            E e = eClass.newInstance();

            if (resultSet.next()) {

                for (int i = 0; i < columnCount; i++) {

                    Object columnValue = resultSet.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field field = eClass.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(e, columnValue);
                }
                return e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return null;
    }





}