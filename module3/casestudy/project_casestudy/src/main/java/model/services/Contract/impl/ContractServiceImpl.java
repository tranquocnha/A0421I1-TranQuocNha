package model.services.Contract.impl;

import model.bean.Contract;
import model.repository.Contract.ContractRepository;
import model.repository.Contract.impl.ContractRepositoryImpl;
import model.services.Contract.ContractService;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository = new ContractRepositoryImpl();

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public boolean saveContract(Contract contract) {
        return contractRepository.saveContract(contract);
    }
}
