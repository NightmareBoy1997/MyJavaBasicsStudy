package org.javasm.supermarket.common;

import lombok.Data;
import org.javasm.supermarket.bean.Product;

import java.math.BigDecimal;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-20 17:24
 */
@Data
public class CartItem {
    private Product product ;
    private Integer buyNumber ;
    private BigDecimal money ;

    public CartItem(Product product , Integer buyNumber){
        this.buyNumber = buyNumber;
        this.product = product;
    }


    public BigDecimal getMoney(){
        money = new BigDecimal(buyNumber.toString()) .multiply( new BigDecimal(product.getProductPrice().toString()));
        return money;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productId =" + product.getId() +
                ", productName =" + product.getProductName() +
                ", productPrice =" + product.getProductPrice() +
                ", buyNumber =" + buyNumber +
                ", money=" + getMoney() +
                '}';
    }



}