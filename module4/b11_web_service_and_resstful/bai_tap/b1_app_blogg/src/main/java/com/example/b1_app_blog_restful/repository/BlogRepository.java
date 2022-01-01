package com.example.b1_app_blog_restful.repository;

import com.example.b1_app_blog_restful.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    List<Blog> findByCategoryId(Long id);

}
