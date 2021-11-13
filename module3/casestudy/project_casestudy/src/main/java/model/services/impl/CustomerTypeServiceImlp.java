package model.services.impl;

import model.bean.CustomerType;
import model.repository.CustomerTypeRepository;
import model.repository.impl.CustomerTypeRepositoryImpl;
import model.services.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImlp implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
