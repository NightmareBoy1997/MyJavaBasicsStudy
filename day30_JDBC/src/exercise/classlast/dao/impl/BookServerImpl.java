package exercise.classlast.dao.impl;

import exercise.classlast.bean.Book;
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
 * @create: 2022-03-15 15:13
 */
public class BookServerImpl implements BookStoreServer {
    BookStoreDao bookStoreDao = new BookStoreDaoImpl();

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);

        String sql = "Insert INTO books(title,author,price,sales,stock,img_path)VALUES(?,?,?,100,100,?)";
        String str = null ;
        Connection connection = null;

        try {
            do {
                // id自增，无需赋值
                //        System.out.print("请输入添加的用户名： ");
                //        int id = scanner.nextInt();
                System.out.print("请输入添加的书名： ");
                String title = scanner.next();
                System.out.print("请输入书的作者： ");
                String author = scanner.next();
                System.out.print("请输入书的价格： ");
                Double price = scanner.nextDouble();
//                System.out.print("请输入书的销量： "); // 默认值100
//                Integer sales = scanner.nextInt();
//                System.out.print("请输入书的库存： ");
//                Integer stock = scanner.nextInt();
                System.out.print("请输入书的封图位置： ");
                String imgPath = scanner.next();
                Book book = new Book(1,title,author,price,100,100,imgPath);

                connection = BookStoreUtils.getConnection();
                bookStoreDao.updateBookStore(connection,sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getImgPath());
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
    public <T> List<T> queryAll() {
//        bookStoreDao.queryList();
        return null;
    }

//    @Override
//    public void add(String sql, Object... objects) {
//        final Connection connection = BookStoreUtils.getConnection();
//        bookStoreDao.updateBookStore(connection,sql,objects);
//    }



}