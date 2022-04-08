package org.javasm.supermarket.server.impl;

import org.apache.commons.dbutils.DbUtils;
import org.javasm.supermarket.bean.Member;
import org.javasm.supermarket.bean.Order;
import org.javasm.supermarket.bean.OrderDetail;
import org.javasm.supermarket.bean.Product;
import org.javasm.supermarket.common.CartItem;
import org.javasm.supermarket.common.CartService;
import org.javasm.supermarket.dao.MemberDao;
import org.javasm.supermarket.dao.OrderDao;
import org.javasm.supermarket.dao.ProductDao;
import org.javasm.supermarket.dao.impl.MemberDaoImpl;
import org.javasm.supermarket.dao.impl.OrderDaoImpl;
import org.javasm.supermarket.dao.impl.ProductDaoImpl;
import org.javasm.supermarket.server.OrderService;
import org.javasm.supermarket.util.DruidUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.server.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-21 18:21
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void addOrder(Member member, BigDecimal totalMoney, int payType) {
        final Connection connection = DruidUtil.getConnection();
        OrderDao orderDao1 = new OrderDaoImpl(connection);
        ProductDao productDao = new ProductDaoImpl();
        MemberDao memberDao = new MemberDaoImpl();

        Order order = new Order();
        order.setMid(member.getMemberId());
        order.setTotalMoney(totalMoney);
        order.setPayType(payType);

        try {
            // 1. 关闭事务自动提交
            connection.setAutoCommit(false);

            // 2. 新增订单表,返回订单id INSERT INTO order (oid,pid,buy_number) VALUES()
            int oid = orderDao1.add(connection, order);

            // 3. 新增订单详情表 INSERT INTO order_detail (oid,pid,buy_number) VALUES()
            final Map<Integer, CartItem> cart = CartService.getCart();
            final Set<Map.Entry<Integer, CartItem>> entrySet = cart.entrySet();
            for (Map.Entry<Integer, CartItem> entry : entrySet) {
                final Integer pid = entry.getKey();
                final Integer buyNumber = entry.getValue().getBuyNumber();
                orderDao1.addOrderAndDetail(oid, pid, buyNumber);


                // 4. 更新商品表
                final Product product = productDao.findProductById(connection, pid);
                if (buyNumber.equals(product.getProductStore())) {
                    product.setProductStore(0);
                    product.setProductStatus(false);
                } else {
                    product.setProductStore(product.getProductStore() - buyNumber);
                }
                productDao.update(connection, product);

                // 5. 更新会员表
                if (payType == 2) {
                    member.setBalance(member.getBalance().subtract(totalMoney));
                    member.setPoint(Double.parseDouble(totalMoney.toString()));
                    memberDao.update(member);
                }
            }

            // 5. 提交事务释放资源
            DbUtils.commitAndClose(connection);

            // 6. 改回connection属性
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            // 7. 回滚事务释放资源
            DbUtils.rollbackAndCloseQuietly(connection);
            throwables.printStackTrace();
        }

    }


    @Override
    public List<Order> findAllOrderOfSort() {

        final List<Order> orderList = findAllOrder();
        orderList.sort((o1, o2) -> -o1.getTotalMoney().compareTo(o2.getTotalMoney()));
        return orderList;

    }

    @Override
    public List<Order> findAllOrder() {
        try {
            return new OrderDaoImpl().findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> findOrderByMemberId(int memberId) {
        try {
            return orderDao.findOrderByMemberId(memberId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public List<OrderDetail> findOrderDetailByOrderId(int orderId) {
        try {
            return orderDao.findOrderDetailByOrderId(orderId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}