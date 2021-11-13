package model.services.impl;

import model.repository.ServiceTypeRepository;
import model.repository.impl.ServiceTypeRepositoryImpl;
import model.services.ServiceType;

import java.util.List;

public class ServiceTypeImpl implements ServiceType {
    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();
    @Override
    public List<model.bean.ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
