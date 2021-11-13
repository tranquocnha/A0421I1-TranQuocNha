package model.services.impl;

import model.bean.Position;
import model.repository.PositionRepository;
import model.repository.impl.PositionRepositoryImpl;
import model.services.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
