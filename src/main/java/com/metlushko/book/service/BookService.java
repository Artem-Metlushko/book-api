package com.metlushko.book.service;

import com.metlushko.book.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<Map.Entry<Long, Book>> getAllBooks();

    Book getBookById(Long id);

    public void addBook(Book book);

    public void updateBook(Book book) ;

    public void deleteBook(Long id);
}
