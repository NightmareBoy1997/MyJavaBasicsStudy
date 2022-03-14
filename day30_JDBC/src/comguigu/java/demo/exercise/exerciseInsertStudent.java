package comguigu.java.demo.exercise;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @projectName: JDBC
 * @package: comguigu.exercise.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-08 16:16
 */
public class exerciseInsertStudent {


    /*
       **代码实现1：插入一个新的student 信息**

    请输入考生的详细信息

    Type:
    IDCard:
    ExamCard:
    StudentName:
    Location:
    Grade:

    信息录入成功!
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] strings = new String[7];
        System.out.print("请输入学生流水号： ");
        strings[0] = input.next();
        System.out.print("请输入学生考试项目(4/6级)： ");
        strings[1]  = input.next();
        System.out.print("请输入学生身份证号： ");
        strings[2]  = input.next();
        System.out.print("请输入学生准考证号： ");
        strings[3]  = input.next();
        System.out.print("请输入学生姓名： ");
        strings[4]  = input.next();
        System.out.print("请输入学生区域： ");
        strings[5]  = input.next();
        System.out.print("请输入学生成绩： ");
        strings[6]  = input.next();

        String sql  = "insert into examstudent(FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade)values(?,?,?,?,?,?,?)";
        int i = preparedStatementExecute(sql, strings);
        if(i>0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }

    }

    /*
    向数据表中添加如下数据：




    **代码实现2：在 eclipse中建立 java 程序：输入身份证号或准考证号可以查询到学生的基本信息。结果如下：**

    **代码实现3：完成学生信息的删除功能**

     */

    //  练习题1：从控制台向数据库的表customers中插入一条数据，表结构如下：**
    @Test
    public void testInsert() {

        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        try {
            Properties properties = new Properties();
            properties.load(inputStream);

            String user = (String) properties.get("user");
            String url = (String) properties.get("url");
            String password = (String) properties.get("password");
            String driverClass = (String) properties.get("driverClass");

            Class.forName(driverClass);

            Connection connection = DriverManager.getConnection(url, user, password);

            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            @Cleanup
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, "薛之谦");
            preparedStatement.setObject(2, "xuezhiqian@qq.com");
            java.util.Date date = new java.util.Date();
            Date sqlDate = new Date(date.getTime());
            preparedStatement.setObject(3, sqlDate);

            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // **练习题2：创立数据库表 examstudent，表结构如下：**

    // 获取Connection实例的方法
    public static Connection getConnection() throws Exception {
        @Cleanup
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        String user = (String) properties.get("user");
        String password = (String) properties.get("password");
        String url = (String) properties.get("url");
        String driverClass = (String) properties.get("driverClass");

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }


    // 通用的增删改 操作
    public static int  preparedStatementExecute(String sql, Object... objects) {
        PreparedStatement preparedStatement = null;
        try{
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            int length = objects.length;

            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i+1, objects[i]);
            }
            // execute 如果执行的是查询操作有返回结果，则返回true
            // 如果执行的是增删改没有返回结果的操作，则返回false
//            preparedStatement.execute();

            // 返回改动了几条数据，操作失败返回0
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(preparedStatement != null){

                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return 0;
    }




}