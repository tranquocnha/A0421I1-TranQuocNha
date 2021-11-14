package model.repository.RentType;

import model.bean.RentType;

import java.util.List;

public interface RentTypeRepository {
    List<RentType> findAll();
}
