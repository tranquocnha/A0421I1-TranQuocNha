package model.services.impl;

import model.bean.Division;
import model.repository.DivisionRepository;
import model.repository.impl.DivisionRepositoryImpl;
import model.services.DivisionService;

import java.util.List;

public class DivisionServiceImpl implements DivisionService {
    DivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
