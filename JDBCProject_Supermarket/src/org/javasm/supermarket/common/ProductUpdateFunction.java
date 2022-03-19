package org.javasm.supermarket.common;

import org.javasm.supermarket.bean.Product;
import org.javasm.supermarket.bean.Type;
import org.javasm.supermarket.server.impl.TypeServiceImpl;
import org.javasm.supermarket.util.FileUploadingUtil;
import org.javasm.supermarket.util.InputUtil;
import org.javasm.supermarket.util.QueryCacheUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.common
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-19 14:57
 */
public class ProductUpdateFunction {


    @Test
    public void test() {
        updateType(new Product());
    }


    public boolean updateName(Product product) {
        System.out.print("请输入修改后的商品名称: ");
        String name = InputUtil.next();
        if(product.getProductName().equals(name)){
            System.out.println("与当前名称一致，无需修改！");
            return false;
        }
        product.setProductName(name);
        return true;
    }


    public boolean updateType(Product product) {
        final TypeServiceImpl typeService = new TypeServiceImpl();
        typeService.findAllType();
        System.out.print("请输入要关联的类型id: ");
        int typeId = InputUtil.nextInt();

        final List<Type> allType = QueryCacheUtil.getAllCacheList(Type.class);
        if (allType.stream().filter(t -> t.getId().equals(typeId)).count() == 0) {
            System.out.println("要关联的类型不存在，修改失败！");
            return false;
        }
        product.setTypeId(typeId);
        return true;
    }

    public void updatePrice(Product product) {
        System.out.print("请输入修改后的商品价格: ");
        double price = InputUtil.nextDouble();
        product.setProductPrice(price);
    }

    public void updateStore(Product product) {
        System.out.print("请输入修改后的库存数量： ");
        int store = InputUtil.nextInt();
        product.setProductStore(store);
    }

    public void updateImage(Product product) {
        System.out.println("请输入要上传的图片源文件路径: ");
        InputUtil.nextLine();
        String sourcePath = InputUtil.nextLine();
        String uploadingPath = FileUploadingUtil.uploadImage(sourcePath);
        product.setProductImage(uploadingPath);
        System.out.println("上传后的路径为： " + uploadingPath );
    }


    public boolean updateStatus(Product product) {
        boolean upStatus = !product.isProductStatus();
        String status = upStatus ? "在售" : "下架";
        System.out.print("是否要修改状态为 " + status + " ？y/n: ");
        String confirm = InputUtil.next("^[Y|y|n|N]$");
        if ("n".equalsIgnoreCase(confirm)) {
            System.out.println("取消修改！");
            return false;
        }
        product.setProductStatus(upStatus);
        return true;
    }

    public boolean updateDiscount(Product product) {
        System.out.println("请输入商品要以几折出售(0~10.0): ");
        double discount = InputUtil.nextDouble();
        if(product.getProductDiscount().equals(discount)){
            System.out.println("当前已经是此折扣状态，无需修改！");
            return false;
        }
        product.setProductDiscount(discount);
        return true;
    }

}