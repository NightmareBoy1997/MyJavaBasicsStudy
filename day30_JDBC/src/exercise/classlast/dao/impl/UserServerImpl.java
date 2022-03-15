package exercise.classlast.dao.impl;

import exercise.classlast.bean.User;
import exercise.classlast.dao.BookStoreDao;
import exercise.classlast.dao.BookStoreServer;
import exercise.classlast.util.BookStoreUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: exercise.classlast.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 14:53
 */
public class UserServerImpl implements BookStoreServer {
    BookStoreDao bookStoreDao = new BookStoreDaoImpl();

    /**
     * 添加用户
     */
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        String sql = "Insert INTO users(username,password,email)VALUES(?,MD5(?),?)";
        String str = null ;
        Connection connection = null;

        try {
            do {
                // id自增，无需赋值
                //        System.out.print("请输入添加的用户名： ");
                //        int id = scanner.nextInt();
                System.out.print("请输入添加的用户名： ");
                String userName = scanner.next();
                System.out.print("请输入添加的用户密码： ");
                String password = scanner.next();
                System.out.print("请输入添加的用户邮箱： ");
                String email = scanner.next();
                User user = new User(1,userName,password,email);

                connection = BookStoreUtils.getConnection();
                bookStoreDao.updateBookStore(connection,sql,user.getUsername(),user.getPassword(),user.getEmail());
                System.out.print("是否继续？(y/n): ");
                str = scanner.next();
            } while (! Objects.equals("n",str));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BookStoreUtils.closeResource(connection,null,null);
        }

    }

    @Override
    public void update(Connection connection, String sql, Object... objects) {

    }

    @Override
    public Integer getValue(String sql) {
        return bookStoreDao.getValue(sql);
    }

    @Override
    public User getInstanceFo(String sql) {
        return bookStoreDao.getInstanceFo(User.class,sql);
    }


    @Override
    public  List<User>  queryAll() {
        List<User> users = null ;
        String sql = "SELECT  id,username , password,email  FROM  users ";
        Class<User> clazz = User.class;
        try {
            users = bookStoreDao.queryAll(clazz, sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


}