package model.repository.Position.impl;

import model.bean.Position;
import model.repository.DBconnection;
import model.repository.Position.PositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements PositionRepository {
    DBconnection dBconnection = new DBconnection();
    protected final String SELECT_ALL_POSITION = "SELECT * from position";
    @Override
    public List<Position> findAll() {
        List<Position> positionList = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                positionList.add(new Position(positionId,positionName));
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}
