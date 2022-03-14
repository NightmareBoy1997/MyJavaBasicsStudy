package comguigu.java.demo.preparedStatement3.crud;

import comguigu.java.demo.bean3.Order;
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
 * @create: 2022-03-08 10:04
 *
 *  针对于表的字段名与类的属性名不相同的情况：
 *   1. 必须声明sql时，使用类的属性名来命名列的别名
 *   2. 使用ResultSetMetaData时，需要使用getColumnLabel() 方法获取列的别名
 *     说明： 如果sql没有给列起别名，getColumnLabel()获取的是列名
 *
 */
public class OrderQuery {




    @Test
    public void test(){

        String sql = "select order_id orderId ,order_name orderName ,order_date orderDate from `order` where order_id =?";
        Order order = testOrderQuery(sql, 1);

        System.out.println(order);
    }

    // 针对order表的通用查询
    public Order testOrderQuery(String sql,Object...objects) {

        ResultSet resultSet = null;

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            int length = objects.length;

            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i+1,objects[i]);
            }

            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()) {
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取列的列名 ： getColumnName()  -- 不推荐使用
                    // 获取列的别名 ： getColumnLabel()
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order, columnValue);

                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(resultSet != null){
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