package codegym.service;

import codegym.model.Customer;
import codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Iterable<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
