package model.services.EducationDegree.impl;

import model.bean.EducationDegree;
import model.repository.EducationDegree.EducationDegreeRepository;
import model.repository.EducationDegree.impl.EducationDegreeRepositoryImpl;
import model.services.EducationDegree.EducationDegreeService;

import java.util.List;

public class EducationDegreeServiceImpl implements EducationDegreeService {
    EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
