package javasm.demo1;

import org.junit.jupiter.api.Test;
import javasm.util.Utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @projectName: JDBC
 * @package: java.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-11 9:53
 */
public class ConnectionTest {




    @Test
    public void test1() {
        System.out.println("*************");
        final Connection connection = Utils.getConnection();
        System.out.println(connection);
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}