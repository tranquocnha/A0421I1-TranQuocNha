package model.repository.impl;

import model.bean.Product;
import model.repository.DBconnection;
import model.repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private DBconnection dBconnection = new DBconnection();
    private final  String SELECT_ALL_PRODUCT = "select * from product;";
    private final String INSERT_INTO_PRODUCT = "INSERT INTO product(product_name,product_price,product_quantity,product_color,product_address,category_id)" +
            "value(?,?,?,?,?,?);";
    private final String SELECT_BY_PRODUCT = "select * from product where product.product_id = ?;";
    private final String UPDATE_PRODUCT = "UPDATE product set product_name=?,product_price=?,product_quantity=?,product_color=?,product_address=?,category_id=? where product_id=?;";
    private final String DELETE_PRODUCT = "DELETE from product where product.product_id=?;";
    private final String SELECT_BY_NAME_PRODUCT = "SELECT * from product where product.product_name like ?;";
    private final String SELECT_BY_NAME_COLOR_ADDRESS_PRODUCT = "SELECT * from product where product.product_name like ? and product.product_color like ? and product.product_address like ? ;";

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                Double productPrice = resultSet.getDouble("product_price");
                int productQuantity = resultSet.getInt("product_quantity");
                String productColor = resultSet.getString("product_color");
                String productAddress = resultSet.getString("product_address");
                int categoryId = resultSet.getInt("category_id");
                Product product = new Product(productId,productName,productPrice,productQuantity,productColor,productAddress,categoryId);
                productList.add(product);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_BY_PRODUCT);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                Double productPrice = resultSet.getDouble("product_price");
                int productQuantity = resultSet.getInt("product_quantity");
                String productColor = resultSet.getString("product_color");
                String productAddress = resultSet.getString("product_address");
                int categoryId = resultSet.getInt("category_id");
                product = new Product(productId,productName,productPrice,productQuantity,productColor,productAddress,categoryId);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
    @Override
    public void delete(int id) {
        Connection connection= null;
        connection=dBconnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
                preparedStatement.setInt(1,id);
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
    public boolean saveProduct(Product product) {
        Connection connection = null;
        connection = dBconnection.getConnection();
        boolean check = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);

            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getProductPrice());
            preparedStatement.setInt(3, product.getProductQuantity());
            preparedStatement.setString(4,product.getProductColor());
            preparedStatement.setString(5,product.getProductAddress());
            preparedStatement.setInt(6,product.getCategoryId());
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
    public boolean updateProduct(int productId, Product product) {
        Connection connection = null;
        connection = dBconnection.getConnection();
        boolean check = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);

            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getProductPrice());
            preparedStatement.setInt(3, product.getProductQuantity());
            preparedStatement.setString(4,product.getProductColor());
            preparedStatement.setString(5,product.getProductAddress());
            preparedStatement.setInt(6,product.getCategoryId());
            preparedStatement.setInt(7,product.getProductId());
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
    public List<Product> findByName(String productName) {
        List<Product> list = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_BY_NAME_PRODUCT);
            preparedStatement.setString(1,"%"+productName+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int productId = resultSet.getInt("product_id");
                String productNames = resultSet.getString("product_name");
                Double productPrice = resultSet.getDouble("product_price");
                int productQuantity = resultSet.getInt("product_quantity");
                String productColor = resultSet.getString("product_color");
                String productAddress = resultSet.getString("product_address");
                int categoryId = resultSet.getInt("category_id");
                Product product = new Product(productId,productNames,productPrice,productQuantity,productColor,productAddress,categoryId);
                list.add(product);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByNameAndColorAndAddress(String productName, String productColor, String productAddress) {
        List<Product> list = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_BY_NAME_COLOR_ADDRESS_PRODUCT);
            preparedStatement.setString(1,"%"+productName+"%");
            preparedStatement.setString(2,"%"+productColor+"%");
            preparedStatement.setString(3,"%"+productAddress+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int productId = resultSet.getInt("product_id");
                String productNames = resultSet.getString("product_name");
                Double productPrice = resultSet.getDouble("product_price");
                int productQuantity = resultSet.getInt("product_quantity");
                String productColors = resultSet.getString("product_color");
                String productAddresss = resultSet.getString("product_address");
                int categoryId = resultSet.getInt("category_id");
                Product product = new Product(productId,productNames,productPrice,productQuantity,productColors,productAddresss,categoryId);
                list.add(product);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
