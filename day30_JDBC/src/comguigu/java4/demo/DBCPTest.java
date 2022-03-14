package comguigu.java4.demo;

import comguigu.java4.bean.User;
import comguigu.java4.util.JDBCUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.pool.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-12 20:47
 */
public class DBCPTest {
    /**
     * 测试DBCP的数据库连接池技术
     */



    @Test
    public void test(){

        try {
            System.out.println(testGetConnection1());
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }




    // 方式一：
    public void testGetConnection() throws SQLException {

        // 创建了DBCP的数据库连接池
        final BasicDataSource basicDataSource = new BasicDataSource();

        // 设置基本信息
        basicDataSource.setPassword("wei123");
        basicDataSource.setUsername("root");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql:/localhost:3306/test?serverTimezone = GMT");

        // 还可以设置数据库管理的属性
        basicDataSource.setInitialSize(10);

        final Connection connection = basicDataSource.getConnection();
        System.out.println(connection);
    }

    // 方式二 推荐 ： 使用配置文件
    public Connection testGetConnection1() throws Exception {

        // 见代码块
//        FileInputStream inputStream = new FileInputStream("src//dbcp.properties");
//        Properties properties = new Properties();
//        properties.load(inputStream);
//        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

    private static DataSource dataSource = null;

    static {
        try {
            FileInputStream inputStream = new FileInputStream("src//dbcp.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    使用连接池查询单条记录对象的操作
     */
    @Test
    public void test1(){
        Connection connection = null;
        try {
            connection = testGetConnection1();
            String sql = "SELECT id,name,password,address locationCity,phone FROM user WHERE id = ?";

            final User instance = getInstance(connection, User.class, sql, 6);
            System.out.println(instance);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.closeResource(connection,null,null);
        }
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




}