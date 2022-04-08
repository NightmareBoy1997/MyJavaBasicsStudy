package org.javasm.supermarket.common;

import org.javasm.supermarket.bean.Product;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.common
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-20 17:38
 */
public class CartService {
    private CartService() {
    }

    public static Map<Integer, CartItem> cart;

    static {
        cart = new HashMap<>(16);
    }

    public static Map<Integer,CartItem> getCart(){
        return cart;
    }

    public static CartItem getCartItemById(int pid) {
        return cart.get(pid);
    }

    public static void addCart(CartItem item) {
        cart.put(item.getProduct().getId(), item);
    }

    public static void selectAllCartItem() {
        final Set<Map.Entry<Integer, CartItem>> entries = cart.entrySet();
        for (Map.Entry entry : entries) {
            final CartItem cartItem = (CartItem) entry.getValue();
            final Product product = cartItem.getProduct();
            System.out.println("购物项id： " + entry.getKey() + " 商品名称： " + product.getProductName() + "单价： " + product.getProductPrice() + "购买数量： " + cartItem.getBuyNumber());
        }
        System.out.println("$$ 总金额：" + getTotalMoney() + "$$");
    }

//    public static List<Integer> getCartItemId() {
//        final Set<Map.Entry<Integer, CartItem>> entries = cart.entrySet();
//        final List<Integer> idList = entries.stream().map(Map.Entry::getKey).collect(Collectors.toList());
//        return idList;
//    }


    public static void deleteCartItem(int id) {
        cart.remove(id);
    }

    public static BigDecimal getTotalMoney() {
        final Collection<CartItem> values = cart.values();
        final List<BigDecimal> moneys = values.stream().map(CartItem::getMoney).collect(Collectors.toList());
        BigDecimal sumMoney = new BigDecimal("0");
        for (BigDecimal bigDecimal : moneys) {
            sumMoney.add(bigDecimal);
        }
        System.out.println("总金额：" + sumMoney);
        return sumMoney;
    }

}