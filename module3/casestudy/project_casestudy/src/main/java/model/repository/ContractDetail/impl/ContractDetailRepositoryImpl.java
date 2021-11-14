package model.repository.ContractDetail.impl;

import model.bean.ContractDetail;
import model.repository.ContractDetail.ContractDetailRepository;
import model.repository.DBconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDetailRepositoryImpl implements ContractDetailRepository {
    DBconnection dBconnection = new DBconnection();
    private final String INSERT_INTO_CONTRACTDETAIL = "INSERT INTO contract_detail(contract_id,attach_service_id,quantity)" +
            "value(?,?,?);";
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
}
