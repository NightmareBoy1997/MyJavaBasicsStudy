package comguigu.java4.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.pool
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-12 20:23
 */
public class JDBCUtils {
    public static ComboPooledDataSource c3p0PooledDataSource = new ComboPooledDataSource( "goc3p0" );
    public static DruidDataSource druidDataSource = null;
    public static BasicDataSource basicDataSource =null;
    public static Properties properties =null ;

    /**
     * 德鲁伊连接池初始化
     */
    static {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("druid.properties");

        try {
            properties = new Properties();
            properties.load(inputStream);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * DBCP
     */
    static {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("dbcp.properties");

        try {
            properties = new Properties();
            properties.load(inputStream);
            basicDataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private JDBCUtils(){
    }



    /**
     *  c3p0连接池获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnectionC3p0() throws SQLException {
        return c3p0PooledDataSource.getConnection();
    }

    /**
     * DBCP连接池获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnectionDBCP() throws SQLException {
        return basicDataSource.getConnection();
    }

    /**
     *  Druid连接池获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnectionDruid() throws SQLException {
        return druidDataSource.getConnection();
    }


    /**
     *  资源的关闭
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void closeResource(Connection connection , PreparedStatement preparedStatement , ResultSet resultSet){
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
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


    /**
     *  使用DbUtils工具类，实现资源关闭方法
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void closeResource1(Connection connection,PreparedStatement preparedStatement ,ResultSet resultSet){
        DbUtils.closeQuietly(connection,preparedStatement,resultSet);
    }

}