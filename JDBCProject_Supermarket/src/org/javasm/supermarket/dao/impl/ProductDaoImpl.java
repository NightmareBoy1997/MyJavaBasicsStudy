package org.javasm.supermarket.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.javasm.supermarket.bean.Product;
import org.javasm.supermarket.dao.ProductDao;
import org.javasm.supermarket.sql.ProductSql;
import org.javasm.supermarket.util.DruidUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-18 15:47
 */
public class ProductDaoImpl implements ProductDao {
    private static final QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Product> findByTypeId(Connection connection, int typeId) throws SQLException {
        return queryRunner.query(connection, ProductSql.FIND_ALL_PRODUCT_BY_TYPE, new BeanListHandler<>(Product.class), typeId);
    }


    @Override
    public void addAndDelete(Connection connection, Product product) throws SQLException {
        final Integer productId = product.getId();
        if (productId == null) {
            queryRunner.update(connection, ProductSql.INSERT_INTO_PRODUCT, product.getProductName(), product.getTypeId(), product.getProductPrice());
            return;
        }
        queryRunner.update(connection, ProductSql.DELETE_PRODUCT_BY_ID, productId);
    }


    @Override
    public List<Product> findAll(Connection connection) throws SQLException {
        return queryRunner.query(connection, ProductSql.SELECT_ALL_PRODUCT, new BeanListHandler<>(Product.class));
    }


    @Override
    public void update(Connection connection, Product product) throws SQLException {
        queryRunner.update(connection, ProductSql.UPDATE_PRODUCT,
                product.getProductName(),
                product.getTypeId(),
                product.getProductPrice(),
                product.getProductStore(),
                product.getProductImage(),
                product.isProductStatus(),
                product.getProductDiscount(),
                product.getId()
        );
    }


    private Product findProductById(Connection connection, int productId) throws SQLException {
        return queryRunner.query(connection, ProductSql.FIND_PRODUCT_BY_ID, new BeanHandler<>(Product.class), productId);
    }


    @Test
    public void test11() {
        try {
            final Connection connection = DruidUtil.getConnection();
//            findProductByTypeId(connection, 12).stream().forEach(System.out::println);

            Product product = new Product();
            product.setProductName("ssjfja");
            product.setTypeId(324);
            product.setProductPrice(23423.22);
            product.setId(8);
//            Product product = findProductById(connection , 7);
            product.setProductStatus(false);
            product.setProductStore(100);
            addAndDelete(connection, product);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}