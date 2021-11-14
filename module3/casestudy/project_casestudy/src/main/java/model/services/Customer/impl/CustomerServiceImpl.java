package model.services.Customer.impl;

import model.bean.Customer;
import model.repository.Customer.CustomerRepository;
import model.repository.Customer.impl.CustomerRepositoryImpl;
import model.services.Customer.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private final String VALIDATE_CUSTOMER_ID = "(KH)[-][\\d]{4}";
    @Override
    public boolean saveCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @Override
    public Map<String, String> saveCustomer1(Customer customer) {
        Map<String,String> map = new HashMap<>();
        boolean check = true;
        if(customer.getCustomerCode().equals("")){
            check = false;
            map.put("MSS","Ma khong duoc de trong");
        }else if(!validate(customer.getCustomerCode())){
            check = false;
            map.put("MSS","Ma khong dung dinh dang");
        }
        if(check){
        customerRepository.saveCustomer(customer);
        }
        return map;
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
    public boolean validate(String customerCode){
        return customerCode.matches(VALIDATE_CUSTOMER_ID);
    }
}
