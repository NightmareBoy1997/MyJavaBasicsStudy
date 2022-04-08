package org.javasm.supermarket.dao;

import org.javasm.supermarket.bean.Order;
import org.javasm.supermarket.bean.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-21 22:46
 */
public interface OrderDao {

    int add(Connection connection, Order order) throws SQLException;

    List<Order> findAll() throws SQLException;

    void addOrderAndDetail(int oid , int pid , int buyNumber)throws SQLException;

    List<Order> findOrderByMemberId(int memberId) throws SQLException;

    List<OrderDetail> findOrderDetailByOrderId(int OrderId) throws SQLException;


//    void delete(Order order);

}
