package model.services.ContractDetail;

import model.bean.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    boolean saveContractDetail(ContractDetail contractDetail);

    List<ContractDetail> findAll();

}
