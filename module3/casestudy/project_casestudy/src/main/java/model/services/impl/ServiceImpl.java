package model.services.impl;

import model.repository.ServiceRepository;
import model.repository.impl.ServiceRepositoryImpl;
import model.services.Service;

import java.util.List;

public class ServiceImpl implements Service {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    @Override
    public List<model.bean.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean saveService(model.bean.Service service) {
        return serviceRepository.saveService(service);
    }
}
