package codegym.service.categoryService;

import codegym.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
