package com.metlushko.book.service;

import com.metlushko.book.dao.Dao;
import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookServiceImpl  {

    private final Dao dao;


    public List<Book> getAllBooks() {
        return dao.findAll();
    }


    public Book getBookById(Long id) {
        return dao.findById(id).orElseThrow();
    }

    public void addBook(Book book) {
        dao.save(book);
    }

    public void updateBook(Long id,Book book) {
        dao.update(id,book);
    }

    public void deleteBook(Long id) {
        dao.delete(id);
    }

}
