package model.services.Customer;

import model.bean.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    boolean saveCustomer(Customer customer);
    Map<String,String> saveCustomer1(Customer customer);
    List<Customer> findAll();
    void delete(int id);
    boolean updateCustomer(int id,Customer customer);
    Customer findById(int id);
    List<Customer> findByName(String name);

    List<Customer> findByNameAndGenderAndAddress(String name, String gender, String address);

    List<Customer> findByNameAndGenderAndAddressAndEmail(String name, String gender, String address, String email);
}
