package com.example.cesutudy.service.Employee;

import com.example.cesutudy.model.Employee;
import com.example.cesutudy.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return employeeRepository.searchName(name,pageable);
    }

    @Override
    public Set<String> selectName(String name) {
        return employeeRepository.selectName(name);
    }

    @Override
    public boolean existById(int id) {
        return employeeRepository.existsByEmployeeId(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
