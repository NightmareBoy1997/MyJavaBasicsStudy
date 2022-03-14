package comguigu.java3.dao;

import comguigu.java.demo.bean3.Customer;

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
 * @create: 2022-03-11 21:15
 *
 *  此接口用于规范对 Customer 表的常用操作
 *
 */
public interface CustomerDAO {

    /**
     *  将customer对象添加到数据表中
     * @param connection
     * @param customer
     */
    void insert(Connection connection , Customer customer);

    /**
     *  指定id删除数据表中的记录
     * @param connection
     * @param id
     */
    void deleteById(Connection connection , int id);

    /**
     *   根据内存中 customer对象，去修改数据表中指定的纪录
     * @param connection
     */
    void update(Connection connection , Customer customer);

    /**
     *  查询数据表中指定id记录的对象
     * @param connection
     * @param id
     */
    Customer getCustomerById(Connection connection , int id);

    /**
     *  查询数据表中的所有记录
     * @param connection
     * @return
     */
    List<Customer> getAll(Connection connection) ;

    /**
     *  获取数据表中的数据数量
     * @param connection
     * @return
     */
    long getCount(Connection connection);

    /**
     *  获取数据表中最大的生日
     * @param connection
     * @return
     */
    Date getMaxBirth(Connection connection);

}
