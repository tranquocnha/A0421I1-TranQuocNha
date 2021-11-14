package model.services.CustomerType.impl;

import model.bean.CustomerType;
import model.repository.CustomerType.CustomerTypeRepository;
import model.repository.CustomerType.impl.CustomerTypeRepositoryImpl;
import model.services.CustomerType.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImlp implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
