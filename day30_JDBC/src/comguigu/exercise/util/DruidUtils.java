package comguigu.exercise.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-16 16:41
 */
public class DruidUtils {
    static DruidDataSource druidDataSource = null ;

    /** 初始化DruidDataSource
     */
    static {
        final InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("src/comguigu/druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @return 数据库连接Connection对象
     */
    public Connection getConnectionDruid(){
        try {
            return druidDataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }






}