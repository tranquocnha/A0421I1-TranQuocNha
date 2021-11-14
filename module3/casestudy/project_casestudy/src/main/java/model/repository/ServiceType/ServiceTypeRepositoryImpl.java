package model.repository.ServiceType;

import model.bean.ServiceType;
import model.repository.DBconnection;
import model.repository.ServiceType.ServiceTypeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {
    DBconnection dBconnection = new DBconnection();
    private final String SELECT_ALL_SERVICETYPE = "SELECT * from service_type;";
    @Override
    public List<ServiceType> findAll() {
        List<ServiceType> serviceTypes = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_SERVICETYPE);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceTypes.add(new ServiceType(serviceTypeId,serviceTypeName));
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceTypes;
    }
}
