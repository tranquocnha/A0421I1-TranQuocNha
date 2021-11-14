package model.repository.Contract.impl;

import model.bean.Contract;
import model.repository.Contract.ContractRepository;
import model.repository.DBconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractRepositoryImpl implements ContractRepository {
    DBconnection dBconnection = new DBconnection();
    private final String INSERT_INTO_CONTRACT = "INSERT INTO contract(contract_start_date,contract_end_date,contract_deposit" +
            ",contract_total_money,employee_id,customer_id,service_id)" +
            "value(?,?,?,?,?,?,?);";
    @Override
    public boolean saveContract(Contract contract) {
        Connection connection = null;
        connection = dBconnection.getConnection();
        boolean check = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CONTRACT);

            preparedStatement.setDate(1,Date.valueOf(contract.getContractStartDate()));
            preparedStatement.setDate(2,Date.valueOf(contract.getContractEndDate()));
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setDouble(4,contract.getContractTotalMoney());
            preparedStatement.setInt(5,contract.getEmployeeId());
            preparedStatement.setInt(6,contract.getCustomerId());
            preparedStatement.setInt(7,contract.getServiceId());
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
