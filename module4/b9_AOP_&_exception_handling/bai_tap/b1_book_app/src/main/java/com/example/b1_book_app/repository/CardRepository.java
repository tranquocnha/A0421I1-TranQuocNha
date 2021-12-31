package com.example.b1_book_app.repository;

import com.example.b1_book_app.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
