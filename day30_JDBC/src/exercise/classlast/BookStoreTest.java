package exercise.classlast;

import exercise.classlast.bean.User;
import exercise.classlast.dao.BookStoreServer;
import exercise.classlast.dao.impl.BookServerImpl;
import exercise.classlast.dao.impl.UserServerImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: calssLastExercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 0:28
 *
 * # JDBC课后习题自测
 *
 * ## 题目描述：
 *
 * 1、创建数据库test01_bookstore
 *
 * 2、创建如下表格
 *
 * （1）图书表books
 * （2）用户表users
 * （3）订单表orders
 * （4）订单明细表order_items
 *
 *
 * 3、使用sql语句在命令行或SQLyog中添加一些模拟数据
 *
 * 表books：
 * 表users：
 * 表orders：
 * 表order_items：
 *
 * 4、使用JDBC实现往用户表中添加1个用户，注意密码存储使用mysql的password()函数进行加密
 *
 *
 * 5、使用JDBC实现往图书表中添加1本图书
 *
 * 6、从键盘输入用户名和密码，模拟登录，使用JDBC实现验证用户名和密码是否正确，
 * 如果正确，显示登录成功，否则显示用户名或密码错误
 *
 * 7、使用JDBC实现查询所有图书信息
 *
 * 8、使用JDBC实现查询销量最大的图书信息
 *
 * 9、使用JDBC实现修改库存量小于10本的图书的库存量为100
 *
 * 10、从键盘输入用户名，实现查询该用户的订单和订单明细
 *
 * 11、使用JDBC实现删除订单“15275760194821”的相关信息，注意涉及到两张表
 *
 */
public class BookStoreTest {

    static Scanner scanner = new Scanner(System.in);


    //  * 1、创建数据库test01_bookstore
    // 2、创建如下表格
    //
    //（1）图书表books
    // * （1）图书表books
    // * （2）用户表users
    // * （3）订单表orders
    // * （4）订单明细表order_items
    /**
     * 创建数据表插入到 test1_bookstore
     */
//    @Test
//    public void createTable(){
//
//        // 创建 books 表
//        String sql;
////        String sql =  "CREATE  TABLE  books( id int(11) NOT NULL PRIMARY KEY  AUTO_INCREMENT , title varchar(100) NOT NULL , " +
////                "author varchar(100) NOT NULL , price double(11,2) NOT NULL ,sales int(11) NOT NULL , stock int(11) NOT NULL , "
////                + "  img_path varchar(100) NOT NULL ); ";
//
//        // 创建 users 表
////        sql = "CREATE  TABLE user ( id int(11)  NOT NULL PRIMARY KEY AUTO_INCREMENT , username VARCHAR(100) NOT NULL UNIQUE ," +
////                " password VARCHAR (100) NOT NULL , email VARCHAR(100)   )" ;
//
//        // 创建 orders 表
//        sql = "CREATE TABLE orders ( id VARCHAR(100) NOT NULL, order_time DATETIME NOT NULL , total_count int(11) NOT NULL ," +
//                "total_amount DOUBLE(11,2) NOT NULL , state int(11) NOT NULL , user_id int (11) NOT NULL  , PRIMARY KEY(id,user_id) )";
//
//        final Connection connection = BookStoreUtils.getConnection();
//        bookStoreDaoImpl.updateBookStore(connection, sql, null);
//        try {
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//


    public static void main(String[] args) {
//        insertUser();
//        insertBook();
        online();




    }



    // * 4、使用JDBC实现往用户表中添加1个用户，注意密码存储使用mysql的password()函数进行加密
    public static void insertUser() {
        UserServerImpl userServer = new UserServerImpl();
        userServer.add( );
    }


    // * 5、使用JDBC实现往图书表中添加1本图书
    public static void insertBook(){
        BookStoreServer bookServer = new BookServerImpl();
        bookServer.add();
    }


    //         * 6、从键盘输入用户名和密码，模拟登录，使用JDBC实现验证用户名和密码是否正确，
    //            * 如果正确，显示登录成功，否则显示用户名或密码错误
    public static void online(){
        UserServerImpl userServer = new UserServerImpl();
        List<User> users = userServer.queryAll();
//        users.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账户： ");
        final String user = scanner.next();
        System.out.println("请输入密码： ");
        String password = scanner.next();



    }




}