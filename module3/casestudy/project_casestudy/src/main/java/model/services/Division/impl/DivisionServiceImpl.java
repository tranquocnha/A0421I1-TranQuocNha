package model.services.Division.impl;

import model.bean.Division;
import model.repository.Division.DivisionRepository;
import model.repository.Division.impl.DivisionRepositoryImpl;
import model.services.Division.DivisionService;

import java.util.List;

public class DivisionServiceImpl implements DivisionService {
    DivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
