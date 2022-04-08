package org.javasm.supermarket.sql;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.sql
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-21 22:51
 */
public interface OrderSql {

    String INSERT_ORDER = "INSERT INTO `order` (mid , total_money,pay_type , pay_time) VALUES(?,?,?,NOW())";


    String FIND_ALL_ORDER = "SELECT * FROM `order` " ;


    String INSERT_ORDER_DETAIL = "INSERT INTO order_detail (oid,pid,buy_number) VALUES(?,?,?)" ;

    String FIND_ORDER_BY_MEMBER_ID = "SELECT * FROM `order` WHERE member_id = ? " ;

    String FIND_ORDER_DETAIL_BY_ORDER_ID = "SELECT * FROM order_detail WHERE order_id = ? " ;
}
