package codegym.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository {
    String findEnglish(String english);
}
