package com.example.b1_admin_customer_restful.service;

import com.example.b1_admin_customer_restful.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(int id);

    Customer save(Customer customer);

    void remove(int id);
}
