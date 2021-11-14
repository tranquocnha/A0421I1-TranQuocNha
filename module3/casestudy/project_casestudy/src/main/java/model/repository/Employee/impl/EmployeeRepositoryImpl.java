package model.repository.Employee.impl;

import model.bean.Employee;
import model.bean.User;
import model.repository.DBconnection;
import model.repository.Employee.EmployeeRepository;

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
    private final String DELETE_EMPLOYEE = "DELETE from employee where employee_id=? ;";
    private final String DELETE_USER = "DELETE from user where user_name=?;";
    private final String SELECT_BY_ID_EMPLOYEE = "SELECT * from employee where employee_id=?";
    private final String UPDATE_BY_ID_EMPLOYEE = "UPDATE employee set employee_name=?,employee_birthday=?,employee_id_card=?" +
            ",employee_salary=?,employee_phone=?,employee_email=?,employee_address=?,position_id=?,education_degree_id=?" +
            ",division_id=? where employee_id=?;";
    private final String SELECT_BY_NAME_EMPLOYEE = "SELECT * from employee where employee.employee_name like ?;";

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

    @Override
    public void deleteEmployee(int id, String userName) {
        Connection connection= null;
        connection=dBconnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
                PreparedStatement preparedStatement1 = connection.prepareStatement(DELETE_USER);
                preparedStatement.setInt(1, id);
                preparedStatement1.setString(1,userName);
                preparedStatement.executeUpdate();
                preparedStatement1.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_BY_ID_EMPLOYEE);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
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
                employee = new Employee(employeeId,employeeName,employee_birthday,employeeIdCard,employeeSalary,employeePhone,employeeEmail
                        ,employeeAddress,positionId,educationDegreeId,divisionId,userName);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean updateEmployee(int id, Employee employee) {
        Connection connection = null;
        connection = dBconnection.getConnection();
        boolean check = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID_EMPLOYEE);

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
            preparedStatement.setInt(11,employee.getEmployeeId());
            check=preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> list = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_BY_NAME_EMPLOYEE);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
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
                Employee employees = new Employee(employeeId,employeeName,employee_birthday,employeeIdCard,employeeSalary,employeePhone,employeeEmail
                        ,employeeAddress,positionId,educationDegreeId,divisionId,userName);
                list.add(employees);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
