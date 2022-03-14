package comguigu.java.demo.preparedStatement3.crud;

import comguigu.java.demo.bean3.Customer;
import comguigu.java.demo.bean3.User;
import comguigu.java.demo.java3.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @projectName: JDBC
 * @package: comguigu.demo.preparedStatement3.crud
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-11 11:05
 * <p>
 * 1. 事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。
 * > 一组逻辑单元，一个或多个DML操作
 * <p>
 * 2. 事务处理（事务操作）的原则
 * 保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
 * 当在一个事务中执行多个操作时，要么所有的事务都 被提交(commit) ，那么这些修改就永久地保存下来；
 * 要么数据库管理系统将放弃所作的所有修改，整个事务 回滚(rollback) 到最初状态。
 * <p>
 * 3. 数据一旦提交，就不可以回滚
 * <p>
 * 4. 哪些操作会自动提交？
 * > DDL操作
 * > set autocommit = false 对DDL操作无效
 * > DML默认情况下，一旦执行就会提交。
 * > 我们可以通过set autocommit = false 方式来取消自动提交
 * > 默认在关闭连接时，会自动提交数据
 * <p>
 * 5. 事务的ACID属性
 * <p>
 * 5.1 原子性(Atomicity)
 * 事务是一个不可分割的工作单位，要么都不发生，要么都发生
 * 5.2 一致性(Consistency)
 * 事务必须从一个一致性变换到另一个一致性状态
 * 5.3 隔离性(Isolation)
 * 事物的执行不能被其他事务干扰，即一个事务内部的操作和使用的数据 对 并发的其他事务是隔离性的，并发执行不能相互干扰
 * 5.4 持久性(Durability)
 * 一个事务一旦提交，他对数据库中的数据改变是永久的，下面的操作和数据库故障不应该对其有任何影响
 */
public class TransactionTest {


    /*
    针对数据表user_table
    AA 给 BB用户转账100
    update user_table set balance = balance - 100 where name = 'AA'
    update user_table set balance = balance + 100 where name = 'BB'
    version 1.0
    *****************************未考虑数据库事务*******************************
     */
    @Test
    public void testUpdate() {

        String sql = "update user_table set balance = balance - 100 where user = ?";
        JDBCUtils.update(sql, "AA");

        //
        // 模拟网络的异常
        System.out.println(10 / 0);  // 程序终止，但AA余额已经扣除

        sql = "update user_table set balance = balance + 100 where user = ?";
        JDBCUtils.update(sql, "BB");

        System.out.println("转账成功！");
    }


    /*
    针对数据表user_table
    AA 给 BB用户转账100
    update user_table set balance = balance - 100 where name = 'AA'
    update user_table set balance = balance + 100 where name = 'BB'
    version 2.0
    *****************************考虑数据库事务*******************************
    1. 手动传入Connection对象
    2. 取消自动提交
    3. 执行完成以后手动提交
    4. 如果出现异常，执行回滚操作
     */
    @Test
    public void testTransaction() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            // 1. 取消数据的自动提交
            connection.setAutoCommit(false);

            String sql = "update user_table set balance = balance - 100 where user = ?";

            updateTransaction(connection, sql, "AA");
            System.out.println("AA转出完成！");
            // 模拟网络的异常
//            System.out.println(10/0);  // 程序终止，AA余额返回

            sql = "update user_table set balance = balance + 100 where user = ?";
            updateTransaction(connection, sql, "BB");

            // 2. 执行完成后，手动提交
            connection.commit();

            System.out.println("转账成功！");

        } catch (Exception e) {
            e.printStackTrace();

            // 3. 如果有异常，回滚数据
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } finally {
            // 4. 将自动提交 改回默认值
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            // 5. 事务完成关闭资源
            JDBCUtils.closeResource(connection, null);

        }

    }


    /**
     * JDBC的增删改 通用操作
     * version 1.0
     * *****************************考虑数据库事务*******************************
     *
     * @param sql
     * @param objects
     */
    public static void updateTransaction(Connection connection, String sql, Object... objects) { // 占位符的个数应该与可变形参的个数一致

        // 1. 预编译sql语句，返回PreparedStatement的实例
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            // 2. 填充占位符
            int number = objects.length;
            for (int i = 0; i < number; i++) {
                preparedStatement.setObject(i + 1, objects[i]); // 注意参数声明，sql首索引为1
            }

            // 3. 执行操作
            preparedStatement.execute();

            // 4. 资源关闭
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * JDBC的增删改 通用操作
     * version 2.0
     * *****************************未考虑数据库事务*******************************
     *
     * @param sql
     * @param objects
     */
    public static void update(String sql, Object... objects) { // 占位符的个数应该与可变形参的个数一致

        // 1. 获取数据库连接
        // 2. 预编译sql语句，返回PreparedStatement的实例
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            connection.setAutoCommit(false);
            // 3. 填充占位符
            int number = objects.length;
            for (int i = 0; i < number; i++) {
                preparedStatement.setObject(i + 1, objects[i]); // 注意参数声明，sql首索引为1
            }

            // 4. 执行操作
            preparedStatement.execute();

            // 5. 资源关闭
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //*************************************************************************
    @Test
    public void testTransactionSelect() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            // 修改连接的隔离级别
//            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            // 查询连接的隔离级别
            System.out.println(connection.getTransactionIsolation());
            // 取消自动提交
            connection.setAutoCommit(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "select user,password,balance from user_table where user =?";
        final User user = getInstance(connection, User.class, sql, "CC");

        System.out.println(user);
    }

    @Test
    public void testTransactionUpdate() {
        try {
            Connection connection = JDBCUtils.getConnection();

            // 查询连接的隔离级别
            System.out.println(connection.getTransactionIsolation());
            // 取消自动提交
            connection.setAutoCommit(false);

            String sql = "update user_table set balance = ? where user = ?";
            update(sql, 5000, "CC");

            Thread.sleep(15000);
            System.out.println("修改结束！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 通用的查询操作，用于返回数据表的一条记录(version 2.0 考虑事务)
    public <T> T getInstance(Connection connection, Class<T> T, String sql, Object... objects) {
        PreparedStatement preparedStatement = null;
        int length = objects.length;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                final T t = T.newInstance();
                final ResultSetMetaData metaData = preparedStatement.getMetaData();
                final int columnCount = metaData.getColumnCount();

                for (int i = 0; i < columnCount; i++) {
                    final Object columnValue = resultSet.getObject(i + 1);
                    final Field field = T.getDeclaredField(metaData.getColumnLabel(i + 1));
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, preparedStatement, resultSet);
        }
        return null;
    }


    @Test
    public void test() {

        String sql = "select * from customers where id = ?";
        try {

            final Connection connection = JDBCUtils.getConnection();
            final Customer instance1 = getInstance(connection, Customer.class, sql, 3);
            System.out.println(instance1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}