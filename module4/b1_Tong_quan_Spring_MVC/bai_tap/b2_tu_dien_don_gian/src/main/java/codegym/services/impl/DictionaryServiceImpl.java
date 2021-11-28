package codegym.services.impl;

import codegym.controller.DictionaryController;
import codegym.repository.DictionaryRepository;
import codegym.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Override
    public String findEnglish(String english) {
        return dictionaryRepository.findEnglish(english);
    }
}
