package model.repository.Category.impl;

import model.bean.Category;
import model.repository.Category.CategoryRepository;
import model.repository.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    DBconnection dBconnection = new DBconnection();
    private final String SELECT_ALL_CATEGORY = "select * from category;";
    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                Category category = new Category(categoryId,categoryName);
                categoryList.add(category);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }
}
