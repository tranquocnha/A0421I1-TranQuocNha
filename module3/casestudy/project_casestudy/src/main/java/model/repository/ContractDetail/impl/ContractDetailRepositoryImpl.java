package model.repository.ContractDetail.impl;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.repository.ContractDetail.ContractDetailRepository;
import model.repository.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepositoryImpl implements ContractDetailRepository {
    DBconnection dBconnection = new DBconnection();
    private final String INSERT_INTO_CONTRACTDETAIL = "INSERT INTO contract_detail(contract_id,attach_service_id,quantity)" +
            "value(?,?,?);";
    private final String SELECT_ALL_CONTRACTDETAIL ="SELECT * from contract_detail";

    @Override
    public boolean saveContractDetail(ContractDetail contractDetail) {
        Connection connection = null;
        connection = dBconnection.getConnection();
        boolean check = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CONTRACTDETAIL);

            preparedStatement.setInt(1,contractDetail.getContractId());
            preparedStatement.setInt(2,contractDetail.getAttachServiceId());
            preparedStatement.setInt(3,contractDetail.getQuantity());
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
    public List<ContractDetail> findAll() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CONTRACTDETAIL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                ContractDetail contractDetail = new ContractDetail(contractDetailId,contractId,attachServiceId,quantity);
                contractDetailList.add(contractDetail);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetailList;
    }
}
