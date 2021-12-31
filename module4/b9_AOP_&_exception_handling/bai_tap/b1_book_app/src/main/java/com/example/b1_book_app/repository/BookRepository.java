package com.example.b1_book_app.repository;

import com.example.b1_book_app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
