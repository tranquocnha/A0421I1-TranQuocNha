package com.example.cesutudy.model;

import com.example.cesutudy.validation.DateOfBirth;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contractId;
    @NotBlank
    private String contractStartDate;
    @DateOfBirth
    @NotBlank
    private String contractEndDate;
    @Positive
    private double contractDeposit;
    @Positive
    private double contractTotalMoney;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "serviceId", referencedColumnName = "serviceId")
    private Service service;
    @OneToOne(mappedBy = "contract")
    private ContractDetail contractDetail;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
