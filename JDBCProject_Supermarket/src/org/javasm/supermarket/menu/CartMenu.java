package org.javasm.supermarket.menu;

import org.javasm.supermarket.bean.Member;
import org.javasm.supermarket.bean.Product;
import org.javasm.supermarket.common.CartItem;
import org.javasm.supermarket.common.CartService;
import org.javasm.supermarket.server.MemberService;
import org.javasm.supermarket.server.OrderService;
import org.javasm.supermarket.server.ProductService;
import org.javasm.supermarket.server.impl.MemberServiceImpl;
import org.javasm.supermarket.server.impl.OrderServiceImpl;
import org.javasm.supermarket.server.impl.ProductServiceImpl;
import org.javasm.supermarket.util.InputUtil;
import org.javasm.supermarket.util.LimitUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.menu
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-19 9:46
 */
public class CartMenu {
    private static ProductService productService = new ProductServiceImpl();
    private Member member;


    public void menu() {
        do {
            System.out.println("********************** 购买商品管理 **********************");
            System.out.println("1. 添加商品");
            System.out.println("2. 修改数量");
            System.out.println("3. 移除购物车商品");
            System.out.println("4. 查询购物车信息");
            System.out.println("5. 购物车结算");
            System.out.println("6. 退   出");

            System.out.print("请选择要进行的操作(1-6): ");
            final int choice = InputUtil.nextInt("^[1-6]$");
            switch (choice) {
                case 1:
                    buyProductFunction();
                    break;
                case 2:
                    setProductBuyNumberFunction();
                    break;
                case 3:
                    deleteProductBuyFunction();
                    break;
                case 4:
                    findAllCartItemFunction();
                    break;
                case 5:
                    pay();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        } while (true);

    }

    private void pay() {
        OrderService orderService = new OrderServiceImpl();
        findAllCartItemFunction();
        BigDecimal totalMoney = CartService.getTotalMoney();
        System.out.println("一共需要支付： " + totalMoney);

        System.out.println("请选择支付方式： ");
        System.out.println("1. 现金支付");
        System.out.println("2. 余额支付");
        System.out.println();
        int payType = InputUtil.nextInt("^[1-2]$");

        switch(payType){
            case 1:
                member = new Member();
                member.setMemberId(-1);
                break;
            case 2:
               payType =  balancePay(totalMoney);
        }
        // 新增订单
        orderService.addOrder(member,totalMoney,payType);

        // 清空购物车
        CartService.cart.clear();
    }

    private int balancePay(BigDecimal totalMoney) {
        do {
            System.out.print("请输入账户： ");
            String user = InputUtil.next();
            System.out.print("请输入密码： ");
            String password = InputUtil.next();

            member = memberService.findMemberByNameAndPassword(user,password);
            if(member==null){
                System.out.println("账号不存在！请重新输入");
                continue;
            }
            break;
        } while (true);
        final BigDecimal balance = member.getBalance();
        if(balance.compareTo(totalMoney) < 0){
            System.out.println("余额不足！请使用现金支付");
            return 1;
        }
        return 2;
    }

    private static MemberService memberService = new MemberServiceImpl();

    private void deleteProductBuyFunction() {
        findAllCartItemFunction();

        System.out.print("请输入要删除的购物项id： ");
        int id = InputUtil.nextInt();
        if(CartService.getCartItemById(id)==null){
            System.out.println("不存在此购物项！");
            return ;
        }
        String productName = CartService.getCartItemById(id).getProduct().getProductName();
        CartService.deleteCartItem(id);
        System.out.println("删除购买 << " + productName + " >> 完成");
    }


    private void findAllCartItemFunction() {
        System.out.println("当前购物车清单如下: ");
        CartService.selectAllCartItem();
    }


    private void setProductBuyNumberFunction() {
        findAllCartItemFunction();
        String isGo;
        do {
            System.out.print("请选择要修改的购物项id： ");
            int id = InputUtil.nextInt();
            if (CartService.getCartItemById(id)==null) {
                System.out.println("不存在此购物项！");
                return;
            }
            final CartItem cartItem = CartService.getCartItemById(id);
            Product product = cartItem.getProduct();
            int execute = 0;

            flag:
            do {
                System.out.println("1. 添加1");
                System.out.println("2. 减少2");
                System.out.println("3. 删除商品");
                System.out.println("4. 结束修改此商品");
                System.out.println("请选择要修改的操作(1-4)： ");

                int number = InputUtil.nextInt("^[1-4]$");
                switch (number) {
                    case 1:
                        if (product.getProductStore().equals(cartItem.getBuyNumber())) {
                            System.out.println("已经添加全部，无法继续添加！");
                            break;
                        }
                        cartItem.setBuyNumber(cartItem.getBuyNumber() + 1);
                        execute += 1;
                        break;
                    case 2:
                        if (!cartItem.getBuyNumber().equals(0)) {
                            System.out.println("已经减去全部数量，购物项删除！");
                            CartService.deleteCartItem(id);
                            break flag;
                        }
                        cartItem.setBuyNumber(cartItem.getBuyNumber() - 1);
                        execute += 1;
                        break;
                    case 3:
                        CartService.deleteCartItem(id);
                        execute += 1;
                    case 4:
                        break flag;
                }
            } while (true);

            if (execute > 0) {
                System.out.println("修改购物商品 << " + product + " >> 完成!");
            }

            System.out.print("是否继续进行购物项修改？(y/n): ");
            isGo = InputUtil.next("^[y|Y|n|N]$");
        } while ("y".equalsIgnoreCase(isGo));
    }


    private void buyProductFunction() {
//        System.out.println("在售的商品如下： ");
        final List<Product> allProductCache = productService.getAllProductCache();
        int total = LimitUtil.getTotal(allProductCache, 3);
        int page = 1;

        do {
            System.out.println("第 << " + page + " >> 页商品信息如下： ");
            int choice = LimitUtil.selectLimitFunction(page, total);
            switch (choice) {
                case 1:
                    buyProduct(allProductCache);
                    break;
                case 2:
                    break;
                case 3:
                    page = 1;
                    break;
                case 4:
                    page -= 1;
                    break;
                case 5:
                    page += 1;
                    break;
                case 6:
                    page = total;
                default:
                    break;
            }
        } while (true);

    }

    private void buyProduct(List<Product> allProductCache) {
        System.out.print("请输入要添加的商品id： ");
        int pid = InputUtil.nextInt();
        Product product = allProductCache.stream().filter(p -> p.getId().equals(pid)).collect(Collectors.toList()).get(0);
        System.out.println("选择的商品信息如下： " + product);

        System.out.println("请输入要购买 << " + product.getProductName() + " >> 的数量：");
        final Integer store = product.getProductStore();
        int buyNumber = InputUtil.nextInt();
        CartItem cartItem = CartService.getCartItemById(pid);

        if (cartItem == null && buyNumber < store) {
            cartItem = new CartItem(product, store);
        } else if (cartItem != null && cartItem.getBuyNumber() + buyNumber < store) {
            cartItem.setBuyNumber(cartItem.getBuyNumber() + buyNumber);
        } else {
            System.out.println("超过库存，无法添加！");
            return;
        }

        // 购买数量可行
        CartService.addCart(cartItem);
        System.out.println("添加 << " + product + " >> " + buyNumber + " 完成");
    }


}