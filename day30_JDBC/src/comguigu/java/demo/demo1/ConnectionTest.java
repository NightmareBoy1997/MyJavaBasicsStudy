package comguigu.java.demo.demo1;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @projectName: JDBC
 * @package: comguigu.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-07 17:27
 */
public class ConnectionTest {

    public static void main(String[] args) {

    }

    // 方式一：
    @Test
    public void testConnection1() throws SQLException {

        // 获取Driver的实现类对象
        Driver driver = new com.mysql.cj.jdbc.Driver() ;
        // jdbc:mysql ： 协议
        // localhost ： IP协议
        // 3306 ： 默认mysql端口号
        // test ： 数据库名
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT" ;
        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","wei123");

        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }


    // 方式二： 对方式一的迭代: 在如下的程序中，不出现第三方API，使得程序有移植性
    @Test
    public void testConnectionTest2() throws Exception {
        // 1. 获取Driver的实现类对象，使用反射实现
        Class aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        // 2. 提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
        // 3. 提供用户名和密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","wei123");
        // 4. 获取连接
        Connection connection = driver.connect(url,info);

        System.out.println(connection);
    }


    // 方式三： 使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {
        // 1. 获取Driver实现类的对象
        Class<?> driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) driverClass.newInstance();

        // 2. 提供另外三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
        String user = "root";
        String password = "wei123";

        // 3. 注册驱动
        DriverManager.registerDriver(driver);

        // 4. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


    // 方式四：可以省略注册驱动
    @Test
    public void testConnection4() throws Exception {
        // 1. 提供三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
        String user = "root";
        String password = "wei123";

        // 2. 加载Mysql的Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 加载自带的驱动，省略注册驱动
//        Driver driver = (Driver) driverClass.newInstance();
        // 原因：
        /*
        在mysql的Driver实现类中，声明了如下的静态代码块
        static {
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException var1) {
                throw new RuntimeException("Can't register driver!");
            }
        }
         */

        // 3. 获取连接
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }


    /*
     5. 方式五(final)：将基本信息声明在配置文件中，通过读取配置文件，建立连接

     此方式的好处：
        1. 实现了数据和代码的分离，实现了解耦
        2. 如果需要修改配置文件信息，避免程序重新打包

     */
    @Test
    public void testConnection5(){

//        ClassLoader classLoader = ConnectionTest.class.getClassLoader();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try(InputStream asStream = classLoader.getResourceAsStream("jdbc.properties");

                ) {
            // 1. 读取配置文件的基本信息
            Properties pros = new Properties();
            pros.load(asStream);
            String user =(String) pros.get("user");
            String password = (String) pros.get("password");
            String url = (String)pros.get("url");
            String driverClass =(String) pros.get("driverClass");

            // 2. 加载驱动
            Class.forName(driverClass);

            // 3. 获取连接
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}