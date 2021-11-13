package model.services.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.services.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public boolean saveCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public boolean updateCustomer(int id, Customer customer) {
        return customerRepository.update(id,customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    // phương thức kiểm tra dữ liệu SOLID,
    public void validate(){

    }
}
