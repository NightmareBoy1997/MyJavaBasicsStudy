package org.javasm.supermarket.dao.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.javasm.supermarket.bean.Order;
import org.javasm.supermarket.bean.OrderDetail;
import org.javasm.supermarket.dao.OrderDao;
import org.javasm.supermarket.sql.OrderSql;
import org.javasm.supermarket.util.DruidUtil;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-21 22:46
 */
public class OrderDaoImpl implements OrderDao {
    QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    static Connection connection;

    public OrderDaoImpl(){}
    public OrderDaoImpl(Connection connection){
        this.connection = connection;
    }


    @Override
    public int add(Connection connection , Order order) throws SQLException {
        return new QueryRunner().query(connection , OrderSql.INSERT_ORDER,new ScalarHandler<BigInteger>(),order.getMid(),order.getTotalMoney(),order.getPayType()) .intValue();
    }

    @Override
    public List<Order> findAll() throws SQLException {
        return queryRunner.query(OrderSql.FIND_ALL_ORDER,new BeanListHandler<>(Order.class,new BasicRowProcessor(new GenerousBeanProcessor())));
    }

    @Override
    public void addOrderAndDetail(int oid, int pid, int buyNumber) throws SQLException {
        new QueryRunner().update(connection, OrderSql.INSERT_ORDER_DETAIL,oid,pid,buyNumber);
    }

    @Override
    public List<Order> findOrderByMemberId(int orderId) throws SQLException {
        return queryRunner.query(OrderSql.FIND_ORDER_BY_MEMBER_ID,new BeanListHandler<>(Order.class,new BasicRowProcessor(new GenerousBeanProcessor())),orderId);
    }

    @Override
    public List<OrderDetail> findOrderDetailByOrderId(int orderId) throws SQLException {
        return queryRunner.query(OrderSql.FIND_ORDER_DETAIL_BY_ORDER_ID,new BeanListHandler<>(OrderDetail.class,new BasicRowProcessor(new GenerousBeanProcessor())),orderId);
    }


//    public


}