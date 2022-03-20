package org.javasm.supermarket.menu;

import org.javasm.supermarket.common.CartItem;
import org.javasm.supermarket.bean.Product;
import org.javasm.supermarket.common.CartService;
import org.javasm.supermarket.common.RoleEnum;
import org.javasm.supermarket.server.ProductService;
import org.javasm.supermarket.server.impl.ProductServiceImpl;
import org.javasm.supermarket.util.InputUtil;
import org.javasm.supermarket.util.LimitUtil;

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


    public void menu() {

        System.out.println("\n欢迎你 " + RoleEnum.CASHIER.getName());
        boolean flag = true;
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
                    new ProductMenu().menu();
                    break;
                case 3:
                    new MemberMenu().menu();
                    break;
                case 4:
                    flag = isBreakApp();
                    break;
                case 5:
                    flag = isBreakApp();
                    break;
                case 6:
                    flag = isBreakApp();
                    break;
                default:
                    break;
            }
        } while (flag);


    }

    private void buyProductFunction() {
        System.out.println("在售的商品如下： ");
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
        CartItem cartItem = CartService.getProductById(pid);

        if(store<buyNumber){
            System.out.println("超过库存，无法添加！");
        }
    }


}