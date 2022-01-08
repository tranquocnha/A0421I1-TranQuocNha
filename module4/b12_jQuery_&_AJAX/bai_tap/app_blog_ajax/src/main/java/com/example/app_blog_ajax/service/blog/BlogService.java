package com.example.app_blog_ajax.service.blog;

import com.example.app_blog_ajax.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByCategoryId(Long id, Pageable pageable);
    Iterable<Blog> findAllByCategoryId(Long id);
    Page<Blog> findTitleAndCateId(String search, Pageable pageable);
}
