package comguigu.java.demo.java3.util;

import comguigu.java.demo.bean3.Customer;
import comguigu.java.demo.bean3.Order;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @projectName: JDBC
 * @package: comguigu.java3.util
 * @author: Nightmare970701
 * @description:操作数据库的工具类
 * @since:
 * @version: JDK11
 * @create: 2022-03-07 22:20
 */
public class JDBCUtils {


    /**
     *  获取数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {

        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        String user = (String) properties.get("user");
        String password = (String) properties.get("password");
        String url = (String) properties.get("url");
        String driverClass = (String) properties.get("driverClass");

        // 2. 加载驱动
        Class.forName(driverClass);

        // 3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }


    /**
     *  JDBC的增删改 通用操作
     * @param sql
     * @param objects
     */
    public static void update(String sql , Object... objects){ // 占位符的个数应该与可变形参的个数一致

        // 1. 获取数据库连接
        // 2. 预编译sql语句，返回PreparedStatement的实例
        try( Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            // 3. 填充占位符
            int number = objects.length;
            for (int i = 0; i < number; i++) {
                preparedStatement.setObject(i+1,objects[i]); // 注意参数声明，sql首索引为1
            }

            // 4. 执行操作
            preparedStatement.execute();

            // 5. 资源关闭
        } catch (Exception e) {
            e.printStackTrace();
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


    /**
     * 使用preparedStatement实现表的通用查询操作,获取结果集合
     *
     * @param eClass
     * @param sql
     * @param objects
     * @param <E>
     */
    public <E> List<E> dataQueryNewInstanceList(Class<E> eClass, String sql, Object... objects) {
        ResultSet resultSet = null;

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            int length = objects.length;
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            //
            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            // 创建对象集合
            ArrayList<E> list = new ArrayList(10);
            // 获取结果集的列数
            int columnCount = metaData.getColumnCount();
            boolean flag = false;

            while(resultSet.next()){
                flag = true;
                E e = eClass.newInstance();
                // 处理结果集一行数据的每一列：给对象属性赋值
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取列的别名
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    // 给对象指定的columnName属性赋值columnLabel，通过反射
                    Field field = eClass.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(e, columnValue);
                }
                list.add(e);
            }
            if(flag){
                return list;
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


    @Test
    public void test(){
        String sql = "select id,name,email,birth from customers where id<?";
        List<Customer> customers = dataQueryNewInstanceList(Customer.class, sql, 12);
        customers.forEach(System.out::println);
        System.out.println("*************");


        sql = "select order_id orderId, order_name orderName ,order_date orderDate from `order` where order_id<?";
        List<Order> orders = dataQueryNewInstanceList(Order.class, sql, 4);
        orders.forEach(System.out::println);
        System.out.println("*************");

        // 可以但不建议，转回Statement的方式
//        sql = "select id,name,email,birth from customers where id<12";
//        List<Customer> customers1 = dataQueryNewInstanceList(Customer.class, sql);
//        customers1.forEach(System.out::println);
//        System.out.println("*************");
//        sql = "select order_id orderId, order_name orderName ,order_date orderDate from `order` ";
//        List<Order> orders1 = dataQueryNewInstanceList(Order.class, sql);
//        orders1.forEach(System.out::println);
    }


    /**
     *  关闭资源
     * @param connection
     * @param Statement
     */
    public static void closeResource(Connection connection , Statement Statement){

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(Statement != null){
            try {
                Statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     *  关闭资源
     * @param connection
     * @param Statement
     */
    public static void closeResource(Connection connection , Statement Statement,ResultSet resultSet){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(Statement != null){
            try {
                Statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


}