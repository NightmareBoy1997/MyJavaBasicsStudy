package org.javasm.supermarket.menu;

import org.javasm.supermarket.bean.Product;
import org.javasm.supermarket.common.ProductUpdateFunction;
import org.javasm.supermarket.server.ProductService;
import org.javasm.supermarket.server.TypeService;
import org.javasm.supermarket.server.impl.ProductServiceImpl;
import org.javasm.supermarket.server.impl.TypeServiceImpl;
import org.javasm.supermarket.util.InputUtil;
import org.javasm.supermarket.util.CacheUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.menu
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-18 17:10
 */
public class ProductMenu {
    private static ProductService productService = new ProductServiceImpl();


    public static void main(String[] args) {
        final ProductMenu productMenu = new ProductMenu();
//        productMenu.showAllType();
//        productMenu.showAllProduct();
        productMenu.menu();
    }


    public void menu() {
        String isGo;
        try {

            do {
                System.out.println("\n--->  << 商品管理 >>");
                System.out.println("1. 添加商品信息");
                System.out.println("2. 修改商品信息");
                System.out.println("3. 删除商品信息");
                System.out.println("4. 查询商品信息");
                System.out.println("5. 退   出");
                System.out.print("请选择要进行的操作：");

                int number = InputUtil.nextInt("^[1-5]$");
                switch (number) {
                    case 1:
                        System.out.println("--> 1. 添加商品信息");
                        addProductFunction();
                        break;
                    case 2:
                        System.out.println("--> 2. 修改商品信息");
                        updateProductFunction();
                        break;
                    case 3:
                        System.out.println("--> 3. 删除商品信息");
                        deleteProductFunction();
                        break;
                    case 4:
                        System.out.println("--> 4. 查询商品信息");
                        showAllProductFunction();
                        break;
                    case 5:
                        System.out.println("<---  << 商品管理 >>");
                        return;
                }

                System.out.print("是否继续进行商品管理？y/n: ");
                isGo = InputUtil.next("^[y|n|Y|N]$");
            } while ("y".equalsIgnoreCase(isGo));

        } finally {
            // 更新缓存库
            CacheUtil.updateCache(Product.class);
        }
    }


    private void updateProductFunction() {
        showAllProductFunction();
        String isGo ;

        do {
            System.out.print("请输入要修改的商品id: ");
            int id = InputUtil.nextInt();

            Product product = getProduceById(id);
            if (product == null) {
                System.out.println("不存在此id的商品，操作失败！");
                System.out.println("---> << 商品管理 >>");
                return;
            }

            ProductUpdateFunction updateFunction = new ProductUpdateFunction();
            boolean execute = true;

            System.out.println("\n1. 修改名称");
            System.out.println("2. 修改类别");
            System.out.println("3. 修改价格");
            System.out.println("4. 修改库存");
            System.out.println("5. 更新附图");
            System.out.println("6. 更改状态");
            System.out.println("7. 促销管理");
            System.out.print("请选择要修改的信息(1-7): ");
            final int nextInt = InputUtil.nextInt("^[1-7]$");

            switch (nextInt) {
                case 1:
                    execute = updateFunction.updateName(product);
                    break;
                case 2:
                    execute = updateFunction.updateType(product);
                    break;
                case 3:
                    updateFunction.updatePrice(product);
                    break;
                case 4:
                    updateFunction.updateStore(product);
                    break;
                case 5:
                    updateFunction.updateImage(product);
                    break;
                case 6:
                    execute = updateFunction.updateStatus(product);
                    break;
                case 7:
                    execute = updateFunction.updateDiscount(product);
                    break;
                default:
                    break;
            }

            if (execute) {
                productService.updateProduct(product);
                System.out.println("修改商品 << " + product.getProductName() + " >> 成功！");
            }

            System.out.print("是否继续进行修改操作？y/n： ");
            isGo = InputUtil.next("^[y|n|Y|N]$");
        } while ("y".equalsIgnoreCase(isGo));
    }

    private void deleteProductFunction() {
        showAllProductFunction();
        System.out.println("请输入要删除的商品id");
        int id = InputUtil.nextInt();

        Product product = getProduceById(id);
        if (product == null) {
            System.out.println("不存在此id的商品，操作失败！");
            return;
        }

        productService.addAndDeleteProduct(product);
        System.out.println("删除商品 << " + product.getProductName() + " >> 成功！");
    }


    private void showAllProductFunction() {
        System.out.println("所有商品信息展示如下： ");
        productService.showAllProduct();
    }


    /**
     * 添加商品
     */
    private void addProductFunction() {
        System.out.println("当前在售商品类别如下： ");
        showAllType();

        System.out.println();
        System.out.print("请输入要添加的商品名称： ");
        String productName = InputUtil.next();
        System.out.print("请输入商品所属的类型id： ");
        Integer typeId = InputUtil.nextInt();

        System.out.print("请输入要商品的价格： ");
        Double productPrice = InputUtil.nextDouble();

        Product product = new Product();
        product.setProductName(productName);
        product.setTypeId(typeId);
        product.setProductPrice(productPrice);

        productService.addAndDeleteProduct(product);
        System.out.println("添加 << "+ productName + " >>");
    }


    private void showAllType() {
        TypeService typeService = new TypeServiceImpl();
        typeService.findAllType();
    }


    private Product getProduceById(int productId) {
        final List<Product> productList = productService.getAllProductCache();
        final List<Product> idList = productList.stream().filter(p -> p.getId().equals(productId)).collect(Collectors.toList());
        if (idList.isEmpty()) {
            return null;
        }
        return idList.get(0);
    }

}