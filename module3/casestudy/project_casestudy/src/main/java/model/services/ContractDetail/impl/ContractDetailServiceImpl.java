package model.services.ContractDetail.impl;

import model.bean.ContractDetail;
import model.repository.ContractDetail.ContractDetailRepository;
import model.repository.ContractDetail.impl.ContractDetailRepositoryImpl;
import model.services.ContractDetail.ContractDetailService;

public class ContractDetailServiceImpl implements ContractDetailService {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepositoryImpl();
    @Override
    public boolean saveContractDetail(ContractDetail contractDetail) {
        return contractDetailRepository.saveContractDetail(contractDetail);
    }
}
