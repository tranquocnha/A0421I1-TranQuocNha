package model.repository.Position;

import model.bean.Position;

import java.util.List;

public interface PositionRepository {
    List<Position> findAll();
}
