package model.services.Contract.impl;

import model.bean.Contract;
import model.repository.Contract.ContractRepository;
import model.repository.Contract.impl.ContractRepositoryImpl;
import model.services.Contract.ContractService;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository = new ContractRepositoryImpl();
    @Override
    public boolean saveContract(Contract contract) {
        return contractRepository.saveContract(contract);
    }
}
