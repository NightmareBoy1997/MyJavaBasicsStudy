package org.javasm.supermarket.common;

import org.javasm.supermarket.bean.Order;
import org.javasm.supermarket.bean.OrderDetail;
import org.javasm.supermarket.bean.Product;
import org.javasm.supermarket.server.OrderService;
import org.javasm.supermarket.server.impl.MemberServiceImpl;
import org.javasm.supermarket.server.impl.OrderServiceImpl;
import org.javasm.supermarket.server.impl.ProductServiceImpl;
import org.javasm.supermarket.util.InputUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.common
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-22 16:11
 */
public class OrderDetailMenu {
    OrderService orderService = new OrderServiceImpl();

    public void findOrderDetailByMemberId() {

        System.out.print("请输入要查询的会员id： ");
        int memberId = InputUtil.nextInt();
        int memberById = (int) new MemberServiceImpl().findAllMember().stream().filter(m -> m.getMemberId().equals(memberId)).count();
        if (memberById == 0) {
            System.out.println("输入有误！");
            return;
        }

        final List<Order> orders = orderService.findOrderByMemberId(memberId);
        printOrders(orders);
    }

    public void printOrders(List<Order> orders) {
        for (Order order : orders) {
            List<OrderDetail> details = orderService.findOrderDetailByOrderId(order.getId());
            String payType = order.getPayType();
//            payType.equals("1") ? "现金支付" : "余额支付";

            System.out.print("会员id： " + order.getMid() + " ,购买商品： ");

            for (OrderDetail detail : details) {
                Product product = new ProductServiceImpl().getAllProductCache().stream().filter(p -> p.getId()
                        .equals(detail.getProductId())).collect(Collectors.toList()).get(0);
                System.out.print("[ " + product.getProductName() + " ,单价：" + product.getProductPrice() +
                        " ,购买数量：" + detail.getBuyNumber() + " ] ,");
            }

            System.out.println("消费总金额： " + order.getTotalMoney()
                    + " ,支付方式： " + payType + " ,支付时间： " + order.getPayTime());
        }
    }


    public void orderDetailSort() {
        final List<Order> orderSort = orderService.findAllOrderOfSort();
        printOrders(orderSort);
    }
}

