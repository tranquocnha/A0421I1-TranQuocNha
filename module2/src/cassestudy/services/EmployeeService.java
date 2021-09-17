package cassestudy.services;

import cassestudy.models.Employee;

public interface EmployeeService extends Service {
    public Employee isEmployee(String employeeCode);
}
