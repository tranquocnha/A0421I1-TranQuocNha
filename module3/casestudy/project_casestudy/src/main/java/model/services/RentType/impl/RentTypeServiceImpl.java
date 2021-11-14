package model.services.RentType.impl;

import model.bean.RentType;
import model.repository.RentType.RentTypeRepository;
import model.repository.RentType.impl.RentTypeRepositoryImpl;
import model.services.RentType.RentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    RentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
