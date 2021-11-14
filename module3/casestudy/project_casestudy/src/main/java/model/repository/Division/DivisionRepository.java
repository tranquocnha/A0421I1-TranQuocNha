package model.repository.Division;

import model.bean.Division;

import java.util.List;

public interface DivisionRepository {
    List<Division> findAll();
}
