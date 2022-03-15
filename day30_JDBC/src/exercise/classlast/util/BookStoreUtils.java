package exercise.classlast.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @projectName: MyJavaStudy
 * @package: calssLastExercise.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 0:36
 */
public class BookStoreUtils {

    /**
     *  获取数据库连接 Connection
     * @return
     */
    public static Connection getConnection(){

        Properties properties =new Properties();
        Connection connection = null;
        try( final InputStream inputStream = ClassLoader.getSystemResourceAsStream("jdbc2.properties")

                ) {
            properties.load(inputStream);

            String  url = (String) properties.get("url");
            String user = (String) properties.get("user");
            String driverClass = (String) properties.get("driverClass");
            String password = (String) properties.get("password");

            Class.forName(driverClass);
            connection = DriverManager.getConnection(url,user,password);

        } catch ( Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     *  通用的基本增删改操作
     * @param sql
     * @param objects
     */
    public static int  update(Connection connection ,String sql , Object...objects){
        final int length = objects.length;
        int number = 0 ;

        PreparedStatement preparedStatement =null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i+1,objects[i]);
            }
            number = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeResource(null,preparedStatement,null);
        }
        return number;
    }


    /**
     *  preparedStatement 赋值
     * @param connection
     * @param sql
     * @param objects
     * @return
     * @throws Exception
     */
    public static PreparedStatement setPreparedStatement(Connection connection , String sql , Object...objects ){
        final int length = objects.length;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i+1,objects[i]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return preparedStatement;
    }


    /**
     *  资源关闭
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void closeResource(Connection connection , PreparedStatement preparedStatement , ResultSet resultSet){

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(preparedStatement != null){
            try {
                preparedStatement.close();
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