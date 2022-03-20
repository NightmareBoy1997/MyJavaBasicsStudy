package org.javasm.supermarket.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-16 23:19
 */
public class DruidUtil {
    static DruidDataSource druidDataSource = null;


    private DruidUtil(){
    }

    /**
     * 初始化DruidDataSource
     *
     */
    static {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接connection
     * @return
     */
    public static Connection getConnection(){
        try {
            return druidDataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public static DruidDataSource getDataSource(){
        return druidDataSource;
    }


}