package model.repository.Category;

import model.bean.Category;
import model.bean.Product;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
}
