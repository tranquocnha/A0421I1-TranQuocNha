package model.repository.impl;

import model.bean.Customer;
import model.bean.Service;
import model.repository.ServiceRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private DBconnection dBconnection = new DBconnection();
    private final  String SELECT_ALL_SERVICE = "select * from service;";
    private final String INSERT_INTO_SERVICE = "INSERT INTO service(service_code,service_name,service_area,service_cost" +
            ",service_max_people,standard_room,description_other_convenience,pool_area,number_of_floors,service_type_id,rent_type_id)" +
            "value(?,?,?,?,?,?,?,?,?,?,?);";

    @Override
    public List<Service> findAll() {
        List<Service> list = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int serviceId = resultSet.getInt("service_id");
                String serviceCode = resultSet.getString("service_code");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                Double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                Double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                int serviceTypeId = resultSet.getInt("service_type_id");
                int rentTypeId = resultSet.getInt("rent_type_id");
                Service service = new Service(serviceId,serviceCode,serviceName,serviceArea,serviceCost,serviceMaxPeople,standardRoom,
                        descriptionOtherConvenience,poolArea,numberOfFloors,serviceTypeId,rentTypeId);
                list.add(service);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveService(Service service) {
        Connection connection = null;
        connection = dBconnection.getConnection();
        boolean check = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SERVICE);

            preparedStatement.setString(1,service.getServiceCode());
            preparedStatement.setString(2,service.getServiceName());
            preparedStatement.setInt(3,service.getServiceArea());
            preparedStatement.setDouble(4,service.getServiceCost());
            preparedStatement.setInt(5,service.getServiceMaxPeople());
            preparedStatement.setString(6,service.getStandardRoom());
            preparedStatement.setString(7,service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(8,service.getPoolArea());
            preparedStatement.setInt(9,service.getNumberOfFloors());
            preparedStatement.setInt(10,service.getServiceTypeId());
            preparedStatement.setInt(11,service.getRentTypeId());
            check=preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        }catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return check;
    }
}
