package com.example.b1_book_app.service.card;

import com.example.b1_book_app.model.Card;

import java.util.List;

public interface CardService
{
    List<Card> findAll();

    Card findByid(Integer id);

    Card save(Card card);

    void delete(Integer id);
}
