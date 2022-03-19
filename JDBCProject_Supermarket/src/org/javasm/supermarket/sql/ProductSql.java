package org.javasm.supermarket.sql;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.sql
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 15:45
 */
public interface ProductSql {

    String FIND_ALL_PRODUCT_BY_TYPE = "SELECT id,product_name productName , type_id typeId , product_price productPrice ," +
            "product_store productStore , product_image productImage , product_status productStatus,product_discount productDiscount," +
            "create_time createTime , update_time updateTime FROM product WHERE type_id = ?";


    String INSERT_INTO_PRODUCT = "INSERT INTO product ( product_name, type_id, product_price,  product_discount ," +
            " create_time, update_time)  VALUES( ?,?,?,10,now(),now() )" ;


    String FIND_PRODUCT_BY_ID =  "SELECT id,product_name productName , type_id typeId , product_price productPrice ," +
            "product_store productStore , product_image productImage , product_status productStatus,product_discount productDiscount," +
            "create_time createTime , update_time updateTime FROM product WHERE id = ?";
    String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE id = ?";

    String SELECT_ALL_PRODUCT =  "SELECT id,product_name productName , type_id typeId , product_price productPrice ," +
            "product_store productStore , product_image productImage , product_status productStatus,product_discount productDiscount," +
            "create_time createTime , update_time updateTime FROM product ";
}