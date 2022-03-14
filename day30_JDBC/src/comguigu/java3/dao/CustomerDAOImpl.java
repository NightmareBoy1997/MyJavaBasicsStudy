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
 * @create: 2022-03-11 21:28
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {



    @Override
    public void insert(Connection connection, Customer customer) {
        String sql ="insert into customers (name , email, birth)VALUES(?,?,?)";
        update(connection,sql,customer.getName(),customer.getEmail(),customer.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        update(connection,sql,id);
    }

    @Override
    public void update(Connection connection, Customer customer) {
        String sql = "UPDATE customers SET name=? , email=? ,birth=? WHERE id = ? ";
        update(connection, sql ,customer.getName(),customer.getEmail(),customer.getBirth(),customer.getId());
    }

    @Override
    public Customer getCustomerById(Connection connection, int id) {
        String sql = "SELECT id,name,email,birth FROM customers WHERE id=?";
        return getInstance(connection,Customer.class,sql,id);
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql = "SELECT id,name,email,birth FROM customers";
        return getInstanceList(connection,Customer.class,sql);
    }

    @Override
    public long getCount(Connection connection) {
        String sql = "SELECT COUNT(1) FROM customers";
        return getValue(connection,sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) {
        String sql  = "SELECT MAX(birth) FROM customers " ;
        return getValue(connection,sql);
    }
}