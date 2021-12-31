package com.example.b1_book_app.service.book;

import com.example.b1_book_app.model.Book;
import com.example.b1_book_app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository repository;
    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
