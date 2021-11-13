package model.repository.impl;

import model.bean.RentType;
import model.bean.ServiceType;
import model.repository.RentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements RentTypeRepository {
    DBconnection dBconnection = new DBconnection();
    private final String SELECT_ALL_SERVICETYPE = "SELECT * from rent_type;";
    @Override
    public List<RentType> findAll() {
        List<RentType> rentTypes = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_SERVICETYPE);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                Double rentTypeCost = resultSet.getDouble("rent_type_cost");
                rentTypes.add(new RentType(rentTypeId,rentTypeName,rentTypeCost));
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypes;
    }
}
