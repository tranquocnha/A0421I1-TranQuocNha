package codegym.service.blogservice;

import codegym.model.Blog;
import codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    Iterable<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByAuthorContaining(String author, Pageable pageable);
}