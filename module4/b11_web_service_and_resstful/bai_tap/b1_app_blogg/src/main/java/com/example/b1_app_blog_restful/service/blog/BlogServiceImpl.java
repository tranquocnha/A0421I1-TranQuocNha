package com.example.b1_app_blog_restful.service.blog;

import com.example.b1_app_blog_restful.model.Blog;
import com.example.b1_app_blog_restful.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findAllByCategoryId(Long id) {
        return blogRepository.findByCategoryId(id);
    }
}
