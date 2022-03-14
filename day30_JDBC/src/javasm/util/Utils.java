package javasm.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @projectName: JDBC
 * @package: study.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-11 14:37
 */
public class Utils {

    private Utils(){
    }


    // 获取Connection实例
    public static Connection getConnection() {
        try (final InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("smjdbc.properties");
        ) {
            Properties properties = new Properties();
            properties.load(inputStream);

            final String url = (String) properties.get("url");
            final String user = (String) properties.get("user");
            String password = (String) properties.get("password");
            String driverClass = (String) properties.get("driverClass");

            Class.forName(driverClass);

            final Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 增删改操作
    public static void update(String sql , Object...objects){
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        final int length = objects.length;
        int number = 0  ;

        try{
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i+1, objects[i]);
            }
            number = preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{

            if(number > 0){
                System.out.println("修改成功!");
            }else{
                System.out.println("修改失败！");
            }
            utilClose(connection,preparedStatement);
        }


    }



    public static void  utilClose(Connection connection,PreparedStatement preparedStatement){
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
    }

}