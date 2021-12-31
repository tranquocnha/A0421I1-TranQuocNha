package com.example.b1_book_app.service.card;

import com.example.b1_book_app.model.Book;
import com.example.b1_book_app.model.Card;
import com.example.b1_book_app.repository.BookRepository;
import com.example.b1_book_app.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{
    @Autowired
    CardRepository cardRepository;

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findByid(Integer id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void delete(Integer id) {
        cardRepository.deleteById(id);
    }
}
