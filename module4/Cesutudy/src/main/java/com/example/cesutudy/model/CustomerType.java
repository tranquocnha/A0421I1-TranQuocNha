package com.example.cesutudy.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customeTypeId;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public int getCustomeTypeId() {
        return customeTypeId;
    }

    public void setCustomeTypeId(int customeTypeId) {
        this.customeTypeId = customeTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

}