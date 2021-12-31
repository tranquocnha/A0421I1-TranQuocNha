package com.example.b3_create_cart.services;

import com.example.b3_create_cart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
