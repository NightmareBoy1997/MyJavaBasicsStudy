package org.javasm.supermarket.server;

import org.javasm.supermarket.bean.Product;

import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.server
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-18 17:09
 */
public interface ProductService {

    void addAndDeleteProductFunction(Product product);

    void showAllProduct();

    void updateProduct(Product product);

    List<Product> getAllProductCache();

}