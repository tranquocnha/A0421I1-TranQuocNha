package model.repository;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
    boolean saveCustomer(Customer customer);
    void delete(int id);

    boolean update(int id, Customer customer);

    List<Customer> findByName(String name);
}
