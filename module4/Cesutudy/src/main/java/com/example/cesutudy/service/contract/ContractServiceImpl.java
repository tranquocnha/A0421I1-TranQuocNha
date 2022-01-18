package com.example.cesutudy.service.contract;

import com.example.cesutudy.model.Contract;
import com.example.cesutudy.repository.contract.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    ContractRepo contractRepo;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepo.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllSort(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("contractStartDate"));
        return contractRepo.findAll(pageable);
    }


    @Override
    public Contract findById(int id) {
        return contractRepo.findById(id).orElse(null);
    }

    @Override
    public void create(Contract contract) {
        contractRepo.save(contract);
    }

    @Override
    public void update(Contract contract) {
        contractRepo.save(contract);
    }

    @Override
    public void delete(int id) {
        contractRepo.deleteById(id);
    }

    @Override
    public boolean checkId(String id) {
        return false;
    }
}
