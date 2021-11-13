package model.repository.impl;

import model.bean.Employee;
import model.bean.Service;
import model.bean.User;
import model.repository.EmployeeRepository;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    DBconnection dBconnection = new DBconnection();
    private final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee;";
    private final String INSERT_INTO_EMPLOYEE = "INSERT INTO employee(employee_name,employee_birthday,employee_id_card,employee_salary" +
            ",employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,user_name) " +
            "value(?,?,?,?,?,?,?,?,?,?,?);";
    private final String INSERT_INTO_USER = "insert INTO user(user_name,password) value (?,?);";

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        Connection connection = null;
        connection = dBconnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet =preparedStatement.executeQuery();
            while(resultSet.next()){
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employee_birthday = String.valueOf(resultSet.getDate("employee_birthday"));
                String employeeIdCard = resultSet.getString("employee_id_card");
                Double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String userName = resultSet.getString("user_name");
                Employee employee = new Employee(employeeId,employeeName,employee_birthday,employeeIdCard,employeeSalary,employeePhone,employeeEmail,employeeAddress
                        ,positionId,educationDegreeId,divisionId,userName);
                list.add(employee);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveEmployee(Employee employee, User user) {
        Connection connection = null;
        connection = dBconnection.getConnection();
        boolean check = false;
        boolean check1 = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_EMPLOYEE);
            PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_INTO_USER);
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setDate(2,Date.valueOf(employee.getEmployeeBirthday()));
            preparedStatement.setString(3,employee.getEmployeeIdCard());
            preparedStatement.setDouble(4,employee.getEmployeeSalary());
            preparedStatement.setString(5,employee.getEmployeePhone());
            preparedStatement.setString(6,employee.getEmployeeEmail());
            preparedStatement.setString(7,employee.getEmployeeAddress());
            preparedStatement.setInt(8,employee.getPositionId());
            preparedStatement.setInt(9,employee.getEducationDegreeId());
            preparedStatement.setInt(10,employee.getDivisionId());
            preparedStatement.setString(11,employee.getUserName());
            preparedStatement1.setString(1,user.getUserName());
            preparedStatement1.setString(2,user.getPassword());
            check1=preparedStatement1.executeUpdate()>0;
            if(check1){
                check=preparedStatement.executeUpdate()>0;
            }

            preparedStatement.close();
            preparedStatement1.close();
            connection.close();
        }catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return check;
    }
}
