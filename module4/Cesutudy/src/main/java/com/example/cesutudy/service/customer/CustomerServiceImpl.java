package com.example.cesutudy.service.customer;

import com.example.cesutudy.model.Customer;
import com.example.cesutudy.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAllSort(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("customerName").and(Sort.by("customerAddress").descending()));
        return customerRepository.findAll(pageable);
    }

    @Override
    public boolean checkId(String id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByName(String nameCus, Pageable pageable) {
        return customerRepository.searchName(nameCus, pageable);
    }

    @Override
    public Set<String> selectName(String term) {
        return customerRepository.selectName(term);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
