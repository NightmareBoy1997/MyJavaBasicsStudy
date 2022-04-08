package org.javasm.supermarket.server;

import org.javasm.supermarket.bean.Member;
import org.javasm.supermarket.bean.Order;
import org.javasm.supermarket.bean.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.server
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-21 18:20
 */
public interface OrderService {


    void addOrder(Member member, BigDecimal totalMoney, int payType);


    List<Order> findAllOrderOfSort();

    List<Order> findAllOrder();

    List<Order>  findOrderByMemberId(int memberId);

    List<OrderDetail> findOrderDetailByOrderId(int orderId);


}