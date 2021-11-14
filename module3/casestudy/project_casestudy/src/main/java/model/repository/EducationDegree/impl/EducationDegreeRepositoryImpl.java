package model.repository.EducationDegree.impl;

import model.bean.EducationDegree;
import model.repository.DBconnection;
import model.repository.EducationDegree.EducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements EducationDegreeRepository {
    DBconnection dBconnection = new DBconnection();
    private final String SELECT_ALL_EDUCATIONDEGREE = "SELECT * from education_degree;";
    @Override
    public List<EducationDegree> findAll() {
        List<EducationDegree> positionList = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_EDUCATIONDEGREE);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                positionList.add(new EducationDegree(educationDegreeId,educationDegreeName));
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}
