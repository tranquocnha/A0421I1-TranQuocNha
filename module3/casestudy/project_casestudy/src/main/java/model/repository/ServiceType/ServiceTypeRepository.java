package model.repository.ServiceType;

import model.bean.ServiceType;

import java.util.List;

public interface ServiceTypeRepository {
    List<ServiceType> findAll();
}
