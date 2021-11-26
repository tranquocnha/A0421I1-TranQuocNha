package model.repository.Customer.impl;

import model.bean.Customer;
import model.repository.Customer.CustomerRepository;
import model.repository.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private DBconnection dBconnection = new DBconnection();
    private final String INSERT_INTO_CUSTOMER = "INSERT INTO customer(customer_code,customer_name,customer_birthday,customer_gender" +
        ",customer_id_card,customer_phone,customer_email,customer_address,customer_type_id)" +
        "value(?,?,?,?,?,?,?,?,?);";
    private final  String SELECT_ALL_CUSTOMER = "select * from customer;";
    private final String DELETE_CUSTOMER = "DELETE from customer where customer.customer_id=?;";
    private final String UPDATE_CUSTOMER = "UPDATE customer set customer_code=?,customer_name=?,customer_birthday=?," +
            "customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=?,customer_type_id=? where customer_id=?;";
    private final String SELECT_BY_CUSTOMER = "SELECT * from customer where customer.customer_id=?;";
    private final String SELECT_NAME_CUSTOMER= "SELECT * from customer where customer.customer_name like ?;";
    private final String SELECT_NAME_GENDER_ADDRESS_CUSTOMER= "SELECT * from customer where customer.customer_name like ? " +
            "and customer_gender like ? and customer_address like ?;";
    private final String SELECT_NAME_GENDER_ADDRESS_EMAIL_CUSTOMER= "SELECT * from customer where customer.customer_name like ? " +
            "and customer_gender like ? and customer_address like ? and customer_email like ?;";
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = String.valueOf(resultSet.getDate("customer_birthday"));
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCart = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                Customer customer = new Customer(customerId,customerCode,customerName,customerBirthday,customerGender,customerIdCart
                        ,customerPhone,customerEmail,customerAddress,customerTypeId);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_BY_CUSTOMER);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = String.valueOf(resultSet.getDate("customer_birthday"));
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCart = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customer = new Customer(customerId,customerCode,customerName,customerBirthday,customerGender,customerIdCart
                        ,customerPhone,customerEmail,customerAddress,customerTypeId);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean saveCustomer(Customer customer){
        Connection connection = null;
        connection = dBconnection.getConnection();
        boolean check = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER);

            preparedStatement.setString(1,customer.getCustomerCode());
            preparedStatement.setString(2,customer.getCustomerName());
            preparedStatement.setDate(3,Date.valueOf(customer.getCustomerBirthday()));
            preparedStatement.setString(4,customer.getCustomerGender());
            preparedStatement.setString(5,customer.getCustomerIdCard());
            preparedStatement.setString(6,customer.getCustomerPhone());
            preparedStatement.setString(7,customer.getCustomerEmail());
            preparedStatement.setString(8,customer.getCustomerAddress());
            preparedStatement.setInt(9,customer.getCustomerTypeId());
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
    public void delete(int id) {
        Connection connection= null;
        connection=dBconnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
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
    public boolean update(int id, Customer customer) {
        Connection connection = null;
        connection = dBconnection.getConnection();
        boolean check = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);

            preparedStatement.setString(1,customer.getCustomerCode());
            preparedStatement.setString(2,customer.getCustomerName());
            preparedStatement.setDate(3,Date.valueOf(customer.getCustomerBirthday()));
            preparedStatement.setString(4,customer.getCustomerGender());
            preparedStatement.setString(5,customer.getCustomerIdCard());
            preparedStatement.setString(6,customer.getCustomerPhone());
            preparedStatement.setString(7,customer.getCustomerEmail());
            preparedStatement.setString(8,customer.getCustomerAddress());
            preparedStatement.setInt(9,customer.getCustomerTypeId());
            preparedStatement.setInt(10,id);
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
    public List<Customer> findByName(String name) {
        List<Customer> list = new ArrayList<>();
        Customer customer = null;
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_NAME_CUSTOMER);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = String.valueOf(resultSet.getDate("customer_birthday"));
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCart = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                Customer customer1 =new Customer(customerId,customerCode,customerName,customerBirthday,customerGender,customerIdCart
                        ,customerPhone,customerEmail,customerAddress,customerTypeId);
                list.add(customer1);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Customer> findByNameAndGenderAndAddress(String name, String gender, String address) {
        List<Customer> list = new ArrayList<>();
        Customer customer = null;
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_NAME_GENDER_ADDRESS_CUSTOMER);
            preparedStatement.setString(1,"%"+name+"%");
            preparedStatement.setString(2,"%"+gender+"%");
            preparedStatement.setString(3,"%"+address+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = String.valueOf(resultSet.getDate("customer_birthday"));
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCart = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                Customer customer1 =new Customer(customerId,customerCode,customerName,customerBirthday,customerGender,customerIdCart
                        ,customerPhone,customerEmail,customerAddress,customerTypeId);
                list.add(customer1);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Customer> findByNameAndGenderAndAddressAndEmail(String name, String gender, String address, String email) {
        List<Customer> list = new ArrayList<>();
        Customer customer = null;
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_NAME_GENDER_ADDRESS_EMAIL_CUSTOMER);
            preparedStatement.setString(1,"%"+name+"%");
            preparedStatement.setString(2,"%"+gender+"%");
            preparedStatement.setString(3,"%"+address+"%");
            preparedStatement.setString(4,"%"+email+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = String.valueOf(resultSet.getDate("customer_birthday"));
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCart = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                Customer customer1 =new Customer(customerId,customerCode,customerName,customerBirthday,customerGender,customerIdCart
                        ,customerPhone,customerEmail,customerAddress,customerTypeId);
                list.add(customer1);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
