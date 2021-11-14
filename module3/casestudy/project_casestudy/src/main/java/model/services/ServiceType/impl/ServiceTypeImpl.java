package model.services.ServiceType.impl;

import model.repository.ServiceType.ServiceTypeRepository;
import model.repository.ServiceType.ServiceTypeRepositoryImpl;
import model.services.ServiceType.ServiceType;

import java.util.List;

public class ServiceTypeImpl implements ServiceType {
    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();
    @Override
    public List<model.bean.ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
