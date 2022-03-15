package javasm.test;

import comguigu.java.demo.java3.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @projectName: JDBC
 * @package: com.javasm.test
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-11 15:05
 */
public class PreparedStatementTest {


    @Test
    public void addTest(){
        String sql = "insert into tb_userinfo(name,gender,phone)VALUES(?,?,?)";
        JDBCUtils.update(sql , "王康","男","13021348575");
    }

    @Test
    public void addTest1(){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入姓名: ");

        String next = input.nextLine();



    }


}