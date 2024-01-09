package com.metlushko.book.dao;

import com.metlushko.book.model.Book;

import java.util.List;
import java.util.Map;

public interface BookDao {
    <T> List<Map.Entry<String, Book>> getAllBooks();

    Book getBookById(Long id);

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);
}
