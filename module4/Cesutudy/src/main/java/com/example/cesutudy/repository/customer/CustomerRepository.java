package com.example.cesutudy.repository.customer;

import com.example.cesutudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    @Query(value = "SELECT customer_name FROM customer " +
            " where customer_name like %:name% ", nativeQuery = true)
    Set<String> selectName(@Param("name") String nameCus);
    @Query(value = "SELECT * FROM customer " +
            " where customer_name like %:nameCus% ", nativeQuery = true)
    Page<Customer> searchName(String nameCus, Pageable pageable);
}
