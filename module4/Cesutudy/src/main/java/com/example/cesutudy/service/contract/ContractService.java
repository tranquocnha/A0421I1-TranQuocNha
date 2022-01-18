package com.example.cesutudy.service.contract;

import com.example.cesutudy.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    Page<Contract> findAllSort(int pageNum,int pageSize);
    Contract findById(int id);
    void create(Contract contract);
    void update(Contract contract);
    void delete(int id);
    boolean checkId(String id);
}
