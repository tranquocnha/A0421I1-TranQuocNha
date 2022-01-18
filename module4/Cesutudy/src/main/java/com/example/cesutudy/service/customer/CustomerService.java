package com.example.cesutudy.service.customer;

import com.example.cesutudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface CustomerService {
    Page<Customer> findAllSort(int pageNum, int pageSize);
    boolean checkId(String id);

    void create(Customer customer);

    Customer findById(String id);

    void delete(String id);

    Page<Customer> findByName(String nameCus, Pageable pageable);

    Set<String> selectName(String term);

    List<Customer> findAll();
}
