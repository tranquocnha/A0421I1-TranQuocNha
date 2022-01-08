package com.example.admin_phone.service;

import com.example.admin_phone.model.Smartphone;

import java.util.Optional;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
