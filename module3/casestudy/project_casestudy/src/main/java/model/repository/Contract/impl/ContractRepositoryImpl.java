package model.repository.Contract.impl;

import model.bean.Contract;
import model.bean.Customer;
import model.repository.Contract.ContractRepository;
import model.repository.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    DBconnection dBconnection = new DBconnection();
    private final String INSERT_INTO_CONTRACT = "INSERT INTO contract(contract_start_date,contract_end_date,contract_deposit" +
            ",contract_total_money,employee_id,customer_id,service_id)" +
            "value(?,?,?,?,?,?,?);";
    private final String SELECT_ALL_CONTRACT = "SELECT * from contract";
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

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection=null;
        connection = dBconnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int contractId = resultSet.getInt("contract_id");
                String contractStartDate = String.valueOf(resultSet.getDate("contract_start_date"));
                String contractEndDate = String.valueOf(resultSet.getDate("contract_end_date"));
                Double contractDeposit = resultSet.getDouble("contract_deposit");
                Double contractTotalMoney = resultSet.getDouble("contract_total_money");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int serviceId = resultSet.getInt("service_id");
                Contract contract = new Contract(contractId,contractStartDate,contractEndDate,contractDeposit,contractTotalMoney
                ,employeeId,customerId,serviceId);
                contractList.add(contract);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }
}
