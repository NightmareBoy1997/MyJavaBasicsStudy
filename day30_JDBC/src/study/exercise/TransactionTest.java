package study.exercise;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @projectName: MyJavaStudy
 * @package: study.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-12 0:44
 */
public class TransactionTest {

    public void update(String sql , Object...objects){

        try {
            final Connection connection = getConnection12();
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }






    // 获取Connection数据库连接
    public Connection getConnection12() throws Exception {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = (String) properties.get("url");
        String password = (String) properties.get("password");
        String user = (String) properties.get("user");
        String driverClass = (String) properties.get("driverClass");

        Class.forName(driverClass);

        final Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

}