package model.repository.CustomerType;

import model.bean.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    List<CustomerType> findAll();
}
