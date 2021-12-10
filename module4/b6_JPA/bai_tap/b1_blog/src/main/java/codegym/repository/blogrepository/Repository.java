package codegym.repository.blogrepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository<T>{
    List<T> findAll();

    T findById(Integer id);

    void save(T model);

    void remove(T t);
}