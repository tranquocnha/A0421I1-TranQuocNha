package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(int id);
    void delete(int id);
    boolean saveProduct(Product product);

    boolean updateProduct(int productId, Product product);

    List<Product> findByName(String productName);

    List<Product> findByNameAndColorAndAddress(String productName, String productColor, String productAddress);
}
