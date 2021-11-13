package model.repository.impl;

import model.bean.Customer;
import model.bean.CustomerType;
import model.repository.CustomerTypeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    private DBconnection dBconnection = new DBconnection();
    private final String SELECT_ALL_CUSTOMERTYPE = "SELECT * FROM customer_type;";
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypes = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CUSTOMERTYPE);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerTypes.add(new CustomerType(customerTypeId,customerTypeName));
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypes;
    }
}
