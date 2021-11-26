package model.services.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.repository.impl.ProductRepositoryImpl;
import model.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }



    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public boolean saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    @Override
    public boolean updateProduct(int productId, Product product) {
        return productRepository.updateProduct(productId,product);
    }

    @Override
    public List<Product> findByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public List<Product> findByNameAndColorAndAddress(String productName, String productColor, String productAddress) {
        return productRepository.findByNameAndColorAndAddress(productName,productColor,productAddress);
    }
}
