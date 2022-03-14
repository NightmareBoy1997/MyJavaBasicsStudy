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
 * @create: 2022-03-07 23:08
 * <p>
 * 针对于Customer表的通用操作
 */
public class CustomerForQuery {

    // 查询customers表的一条记录
    @Test
    public void testQuery1() {

        String sql = "select id,name,email,birth from customers where id=?";
        ResultSet resultSet = null;

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setObject(1, 1);

            // 执行并返回结果期
            resultSet = preparedStatement.executeQuery();

            // 处理结果集
            while (resultSet.next()) { // next() : 判断结果集下一条是否有数据，如果有数据，返会true指针下移
                // 获取当前这条数据的字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                // 方式一： 遍历显示
//                System.out.println(id + name + email + birth + phone );

                // 方式二：
//                Object[] data = new Object[]{id,name ,email,birth,phone};

                // 方式三：
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
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

    }


    // 查询customers表的通用操作
    public Customer customersQuery(String sql, Object... objects) {
        ResultSet resultSet = null;

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            resultSet = preparedStatement.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 通过ResultSetMetaData获取结果集的列数
            int columnCount = metaData.getColumnCount();

            if(resultSet.next()){
                Customer customer = new Customer();
                // 处理一行数据的每个列的字段信息
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);

                    // 获取列的字段名
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    // 给customer的columnName属性赋值,利用反射
                    Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);

                    field.set(customer, columnValue);
                }
                return customer;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }



    // 查询customers表的一条数据
    @Test
    public void testQuery() {

        String sql = "select id,name,email,birth from customers where id=?";
        Customer customers = customersQuery(sql, 13);
        System.out.println(customers);

        String sql1 = "select id,name,email,birth from customers where name=?";
        Customer customers1 = customersQuery(sql1, "周杰伦");
        System.out.println(customers1);

    }


}