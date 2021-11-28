package codegym.services;

import org.springframework.stereotype.Service;

@Service
public interface DictionaryService {
    String findEnglish(String english);
}
