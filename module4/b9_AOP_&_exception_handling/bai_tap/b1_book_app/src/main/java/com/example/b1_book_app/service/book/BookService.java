package com.example.b1_book_app.service.book;

import com.example.b1_book_app.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Integer id);

    void save(Book book);

    void delete(Integer id);
}
