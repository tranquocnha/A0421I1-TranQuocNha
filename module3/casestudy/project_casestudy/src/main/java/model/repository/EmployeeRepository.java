package model.repository;

import model.bean.Employee;
import model.bean.User;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    boolean saveEmployee(Employee employee, User user);
}
