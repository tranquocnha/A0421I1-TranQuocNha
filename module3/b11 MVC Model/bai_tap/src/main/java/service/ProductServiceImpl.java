package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Product(1,"Iphone X",25000000,"Điện Thoại Iphone X xuất sứ tại mỹ","Apple"));
//        customers.put(2, new Product());
//        customers.put(3, new Product());
//        customers.put(4, new Product());
//        customers.put(5, new Product());
//        customers.put(6, new Product());
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Product product) {
        customers.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Product product) {
        customers.put(id, product);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
