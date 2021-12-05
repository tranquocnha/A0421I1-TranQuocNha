package codegym.repository;

import codegym.model.Commen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommenRepository {
    List<Commen> findAll();
}
