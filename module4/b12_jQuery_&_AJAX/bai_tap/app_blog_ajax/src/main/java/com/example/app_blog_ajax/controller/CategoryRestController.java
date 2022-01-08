package com.example.app_blog_ajax.controller;


import com.example.app_blog_ajax.model.Blog;
import com.example.app_blog_ajax.model.Category;
import com.example.app_blog_ajax.service.blog.BlogService;
import com.example.app_blog_ajax.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> listCategories() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/view-category/{id}")
    public ResponseEntity<Iterable<Blog>> viewCategory(@PathVariable("id") Long id) {
        List<Blog> blogs = (List<Blog>) blogService.findAllByCategoryId(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}