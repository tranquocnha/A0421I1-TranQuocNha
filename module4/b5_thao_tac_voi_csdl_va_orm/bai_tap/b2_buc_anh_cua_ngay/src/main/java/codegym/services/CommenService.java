package codegym.services;

import codegym.model.Commen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommenService {
    List<Commen> findAll();
}
