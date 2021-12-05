package codegym.services;

import codegym.model.Commen;
import codegym.repository.CommenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommenServiceImpl implements CommenService{
    @Autowired
    CommenRepository commenRepository;
    @Override
    public List<Commen> findAll() {
        return commenRepository.findAll();
    }
}
