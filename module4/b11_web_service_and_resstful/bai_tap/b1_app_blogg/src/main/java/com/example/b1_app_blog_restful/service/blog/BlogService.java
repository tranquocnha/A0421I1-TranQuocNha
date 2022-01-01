package com.example.b1_app_blog_restful.service.blog;

import com.example.b1_app_blog_restful.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();

    Optional<Blog> findById(Long id);

    List<Blog> findAllByCategoryId(Long id);
}
