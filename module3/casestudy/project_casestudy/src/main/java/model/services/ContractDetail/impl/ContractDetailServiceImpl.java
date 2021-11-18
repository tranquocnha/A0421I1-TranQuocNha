package model.services.ContractDetail.impl;

import model.bean.ContractDetail;
import model.repository.ContractDetail.ContractDetailRepository;
import model.repository.ContractDetail.impl.ContractDetailRepositoryImpl;
import model.services.ContractDetail.ContractDetailService;

import java.util.List;

public class ContractDetailServiceImpl implements ContractDetailService {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepositoryImpl();
    @Override
    public boolean saveContractDetail(ContractDetail contractDetail) {
        return contractDetailRepository.saveContractDetail(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
