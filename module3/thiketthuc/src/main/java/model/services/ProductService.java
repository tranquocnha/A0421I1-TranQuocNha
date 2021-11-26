package model.services;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    void delete(int id);
    boolean saveProduct(Product product);

    boolean updateProduct(int productId, Product product);

    List<Product> findByName(String productName);

    List<Product> findByNameAndColorAndAddress(String productName, String productColor, String productAddress);
}
