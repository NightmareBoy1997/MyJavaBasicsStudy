package comguigu.java.demo.preparedStatement3.crud;

import comguigu.java.demo.bean3.Customer;
import comguigu.java.demo.java3.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.*;


/**
 * @projectName: JDBC
 * @package: comguigu.preparedStatement3.crud
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-08 11:13
 */
public class PreparedStatementQuery {


    /**
     * 使用preparedStatement实现表的通用查询操作
     *
     * @param eClass
     * @param sql
     * @param objects
     * @param <E>
     */
    public <E> E dataQueryNewInstance(Class<E> eClass, String sql, Object... objects) {
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


    // 测试
    @Test
    public void test() {
        String sql = "select order_id orderId , order_name orderName, order_date orderDate from `order` where order_id = ?";
        Class eClass = null;
        try {
            eClass = Class.forName("comguigu.demo.bean3.Order");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object order = dataQueryNewInstance(eClass, sql, 1);
        System.out.println(order);

        sql = "select id,name,email,birth from customers where id=?";
        Customer customer = dataQueryNewInstance(Customer.class, sql,2);
        System.out.println(customer);

    }


}