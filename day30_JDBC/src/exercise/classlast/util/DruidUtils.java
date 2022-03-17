package exercise.classlast.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @projectName: MyJavaStudy
 * @package: exercise.classlast.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-16 19:40
 */
public class DruidUtils {
    static DruidDataSource druidDataSource = null;

    /**
     * 初始化DruidDataSource
     */
    static {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("druid2.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @return 获取连接对象Connection
     */
    public static Connection getConnectionDruid(){
        try {
            return druidDataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public static DataSource getDataSource() {
        return druidDataSource;
    }
}