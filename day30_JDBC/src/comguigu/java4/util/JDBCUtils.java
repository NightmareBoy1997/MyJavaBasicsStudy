package comguigu.java4.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
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
    public static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource( "goc3p0" );
    public static DruidDataSource druidDataSource = null;
    public static Properties properties =null ;

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



    private JDBCUtils(){
    }





    /**
     *  获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnectionC3p0() throws SQLException {
        return comboPooledDataSource.getConnection();
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