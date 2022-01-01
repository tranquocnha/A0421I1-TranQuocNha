package com.example.b1_app_blog_restful.repository;

import com.example.b1_app_blog_restful.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
