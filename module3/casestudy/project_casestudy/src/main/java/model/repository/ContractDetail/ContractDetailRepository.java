package model.repository.ContractDetail;

import model.bean.ContractDetail;

import java.util.List;

public interface ContractDetailRepository {
    boolean saveContractDetail(ContractDetail contractDetail);

    List<ContractDetail> findAll();
}
