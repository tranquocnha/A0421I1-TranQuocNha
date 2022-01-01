package com.example.b1_admin_customer_restful.repository;

import com.example.b1_admin_customer_restful.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
