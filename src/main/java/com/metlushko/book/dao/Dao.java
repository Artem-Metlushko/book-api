package com.metlushko.book.dao;

import com.metlushko.book.entity.Book;

import java.util.List;
import java.util.Optional;

public interface Dao {
    Optional<Book> findById(Long id);

    Book save(Book book);

    void update(Long id, Book book);

    void delete(Long id);

    List<Book> findAll();

}
