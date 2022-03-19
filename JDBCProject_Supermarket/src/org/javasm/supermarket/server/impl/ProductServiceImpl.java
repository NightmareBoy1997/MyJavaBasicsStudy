package org.javasm.supermarket.server.impl;

import org.apache.commons.dbutils.DbUtils;
import org.javasm.supermarket.bean.Product;
import org.javasm.supermarket.dao.ProductDao;
import org.javasm.supermarket.dao.impl.ProductDaoImpl;
import org.javasm.supermarket.server.ProductService;
import org.javasm.supermarket.util.DruidUtil;
import org.javasm.supermarket.util.QueryCacheUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.server.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-18 17:49
 */
public class ProductServiceImpl implements ProductService {
    private static final ProductDao productDao = new ProductDaoImpl();
    private static List<Product> allProductList= QueryCacheUtil.getAllCacheList(Product.class);


    @Override
    public void addAndDeleteProductFunction(Product product) {
        Connection connection = DruidUtil.getConnection();
        try {
            productDao.addAndDelete(connection , product);
            // 更新缓存
            allProductList = productDao.findAll(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbUtils.closeQuietly(connection);
        }
    }


    @Override
    public void showAllProduct() {
/*//    allProductList.stream().forEach(System.out::println); s
        System.out.println("\t\t\t\t\t< 基本信息 >");
        System.out.println("| 商品id | 商品名称 | 所属类型id | 价格 | 商品库存 | 商品图片 | 商品状态 | 商品折扣 | 创建时间 | 修改时间 |");
        for (Product p : allProductList) {
            System.out.println( "\t" + p.getId() + "\t\t" + p.getProductName() + "\t" + p.getTypeId()  + "\t" +
                    p.getProductPrice() + "\t" +  p.getProductStore()  + "\t" + p.getProductImage()  +
                    "\t" +  p.getProductDiscount()  + "\t" + p.getCreateTime()  + "\t" +  p.getUpdateTime()  );
        }*/

        for (Product p : allProductList) {
            String status ;
            String discount ;
            final Double productDiscount = p.getProductDiscount();
            if (p.isProductStatus()) {
                status = "在售";
            }else{
                status = "下架";
            }
            if (productDiscount.equals(10.0)) {
                discount = "未打折";
            }else{
                discount = productDiscount + "折";
            }

            System.out.println( "\tid: " + p.getId() + "\t名称: " + p.getProductName() + "\t类型id: " + p.getTypeId()  + "\t价格: " +
                    p.getProductPrice() + "\t库存: " +  p.getProductStore()  + "\t图片: " + p.getProductImage()  + "\t状态: "+ status +
                    "\t折扣: " +  discount  + "\t创建时间: " + p.getCreateTime()  + "\t修改时间: " +  p.getUpdateTime()  );
        }
    }


    @Override
    public void updateProduct(Product product) {
        Connection connection = DruidUtil.getConnection();
        try {
            productDao.update(connection,product);

            // 更新缓存
            allProductList = productDao.findAll(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbUtils.closeQuietly(connection);
        }
    }


    public List<Product> getAllProductCache(){
        return allProductList;
    }



}