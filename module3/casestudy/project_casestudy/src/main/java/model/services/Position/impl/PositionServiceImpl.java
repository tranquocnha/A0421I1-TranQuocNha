package model.services.Position.impl;

import model.bean.Position;
import model.repository.Position.PositionRepository;
import model.repository.Position.impl.PositionRepositoryImpl;
import model.services.Position.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
