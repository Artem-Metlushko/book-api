package com.metlushko.book.service;

import com.metlushko.book.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    public void addBook(Book book);

    public void updateBook(Book book) ;

    public void deleteBook(Long id);
}
