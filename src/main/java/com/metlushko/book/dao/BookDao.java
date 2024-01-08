package com.metlushko.book.dao;

import com.metlushko.book.model.Book;

import java.util.List;

public interface BookDao {
    <T> List<T> getAllBooks();

    Book getBookById(Long id);

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);
}
