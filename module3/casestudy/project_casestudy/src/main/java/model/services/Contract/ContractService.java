package model.services.Contract;

import model.bean.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    boolean saveContract(Contract contract);
}
