package model.repository.impl;

import model.bean.Division;
import model.bean.EducationDegree;
import model.repository.DivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements DivisionRepository {
    DBconnection dBconnection = new DBconnection();
    private final String SELECT_ALL_DIVISION = "SELECT * from division;";
    @Override
    public List<Division> findAll() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                divisionList.add(new Division(divisionId,divisionName));
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }
}
