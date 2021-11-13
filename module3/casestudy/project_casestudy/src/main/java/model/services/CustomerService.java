package model.services;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    boolean saveCustomer(Customer customer);
    List<Customer> findAll();
    void delete(int id);
    boolean updateCustomer(int id,Customer customer);
    Customer findById(int id);
    List<Customer> findByName(String name);
}
