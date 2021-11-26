package model.services.Category.impl;

import model.bean.Category;
import model.repository.Category.CategoryRepository;
import model.repository.Category.impl.CategoryRepositoryImpl;
import model.services.Category.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
