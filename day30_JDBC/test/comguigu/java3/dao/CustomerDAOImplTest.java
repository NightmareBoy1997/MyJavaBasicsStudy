package comguigu.java3.dao;

import comguigu.java.demo.bean3.Customer;
import comguigu.java.demo.java3.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.java3.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-11 21:54
 */
class CustomerDAOImplTest {
    private CustomerDAOImpl dao = new CustomerDAOImpl();

    @Test
    void insert() {
        try {
            Connection connection = JDBCUtils.getConnection();
            Customer customer = new Customer(1, "张飞", "zhangfei@qq.com", new java.sql.Date(new Date().getTime()));
            dao.insert( connection , customer );
            System.out.println("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteById() {
        try {
            final Connection connection = JDBCUtils.getConnection();
            dao.deleteById(connection , 23);
            System.out.println("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testUpdate() {
        String sql = "UPDATE customers  SET name = ? , email =? WHERE id =? ";

        try {
            final Connection connection = JDBCUtils.getConnection();
            dao.update(connection,sql,"张翼德","zhangyide@qq.com",26);
            System.out.println("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getCustomerById() {

        try {
            final Connection connection = JDBCUtils.getConnection();
            final Customer instance = dao.getCustomerById(connection,25);
            System.out.println(instance);
            System.out.println("查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAll() {
        try {
            final Connection connection = JDBCUtils.getConnection();
            final List<Customer> list = dao.getAll(connection);
            list.stream().forEach(System.out::println);
            System.out.println("查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getCount() {
        final long count;
        try {
            final Connection connection = JDBCUtils.getConnection();
            count = dao.getCount(connection);
            System.out.println("表中的记录总数为： " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void getMaxBirth() {
        try {
            final Connection connection = JDBCUtils.getConnection();
            final Date maxBirth = dao.getMaxBirth(connection);
            System.out.println("最大的生日是： " + maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}