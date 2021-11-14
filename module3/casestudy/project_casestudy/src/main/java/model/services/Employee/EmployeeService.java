package model.services.Employee;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.User;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    boolean saveEmployee(Employee employee, User user);

    void deleteEmployee(int id, String userName);

    Employee findById(int id);

    boolean updateEmployee(int id, Employee employee);

    List<Employee> findByName(String name);
}
