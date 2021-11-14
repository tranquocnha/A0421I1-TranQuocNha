package model.repository.EducationDegree;

import model.bean.EducationDegree;

import java.util.List;

public interface EducationDegreeRepository {
    List<EducationDegree> findAll();
}
