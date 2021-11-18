package model.repository.Contract;

import model.bean.Contract;

import java.util.List;

public interface ContractRepository {
    boolean saveContract(Contract contract);

    List<Contract> findAll();
}
