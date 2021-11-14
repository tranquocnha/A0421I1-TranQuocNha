package model.repository.Contract;

import model.bean.Contract;

public interface ContractRepository {
    boolean saveContract(Contract contract);
}
