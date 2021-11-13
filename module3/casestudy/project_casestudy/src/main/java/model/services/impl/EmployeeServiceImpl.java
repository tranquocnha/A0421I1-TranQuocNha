package model.services.impl;

import model.bean.Employee;
import model.bean.User;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean saveEmployee(Employee employee, User user) {
        return employeeRepository.saveEmployee(employee,user);
    }

    @Override
    public void deleteEmployee(int id, String userName) {
        
    }
}
