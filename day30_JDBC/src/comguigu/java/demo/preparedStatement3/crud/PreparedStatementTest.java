package comguigu.java.demo.preparedStatement3.crud;

import comguigu.java.demo.java3.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @projectName: JDBC
 * @package: comguigu.preparedStatement
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-07 21:25
 */
/*
    使用PreparedStatement来替换Statement，实现对数据库表的增删改查
    增删改；查


 */
public class PreparedStatementTest {

    public static void main(String[] args) {


    }


    // 使用通用方法 删除数据库数据
    @Test
    public void delete(){

        String sql = "delete from customers where id = ?";
        JDBCUtils.update(sql , 20);
        sql = "insert into user(name,password,phone)values(?,?,?) ";
        JDBCUtils.update(sql,"樱木","yingmuhuadao","13234333433");

        sql = "update `order` set order_name=? where order_id=?";
        JDBCUtils.update(sql,"DD","2");

    }


    // 修改customers表中的一条记录
    @Test
    public void testUpdate() {
        String sql = "update customers set name = ? where id = ? ";

        try( Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            // 1. 获取数据库连接
            // 2. 预编译sql语句，返回PreparedStatement的实例

            // 3. 填充占位符
//            preparedStatement.setString(1,"樱木");
            preparedStatement.setObject(1,"樱木花道");
//            preparedStatement.setInt(2,20);
            preparedStatement.setObject(2,20);

            // 4. 执行操作
            preparedStatement.execute();

            // 5. 资源关闭
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    // 向customers表中添加一条记录
    @Test
    public void testPreparedStatement() {

        Connection connection = null;
        PreparedStatement ps = null;

        // 1. 读取配置文件的基本信息
        try (InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");


        ) {
            Properties properties = new Properties();
            properties.load(inputStream);

            String user = (String) properties.get("user");
            String password = (String) properties.get("password");
            String url = (String) properties.get("url");
            String driverClass = (String) properties.get("driverClass");

            // 2. 加载驱动
            Class.forName(driverClass);

            // 3. 获取连接
            connection = DriverManager.getConnection(url, user, password);

            // 4. 预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into customers(name,email,birth)values(?,?,?)"; // ? 占位符
            ps = connection.prepareStatement(sql);

            // 5. 填充占位符
            ps.setString(1, "罗然");
            ps.setString(2, "nightmare97@qq.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = "2007-10-01";
            Date date = simpleDateFormat.parse(dateString);
            ps.setDate(3, new java.sql.Date(date.getTime()));

            // 6. 执行sql操作
            ps.execute();

            // 7. 关闭资源

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }


}