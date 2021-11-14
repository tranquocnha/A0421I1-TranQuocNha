package model.services.Employee.impl;

import model.bean.Employee;
import model.bean.User;
import model.repository.Employee.EmployeeRepository;
import model.repository.Employee.impl.EmployeeRepositoryImpl;
import model.services.Employee.EmployeeService;

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
        employeeRepository.deleteEmployee(id,userName);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean updateEmployee(int id, Employee employee) {
        return employeeRepository.updateEmployee(id,employee);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }


}
