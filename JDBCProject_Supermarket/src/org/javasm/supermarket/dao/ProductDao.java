package org.javasm.supermarket.dao;

import org.javasm.supermarket.bean.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-18 15:46
 */
public interface ProductDao {


    List<Product> findProductByTypeId(Connection connection , int typeId) throws SQLException;


    void addAndDelete(Connection connection, Product product) throws SQLException;

    List<Product> findAllProduct(Connection connection) throws SQLException;


}