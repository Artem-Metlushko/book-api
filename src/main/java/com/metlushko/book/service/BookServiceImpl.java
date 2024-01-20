package com.metlushko.book.service;

import com.metlushko.book.dao.Dao;
import com.metlushko.book.entyti.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl  {

    private final Dao dao;


    public List<Book> getAllBooks() {
        return dao.findAll();
    }


    public Book getBookById(Long id) {
        return dao.findById(id).orElseThrow();
    }

    public Book addBook(Book book) {
        return dao.save(book);
    }

    public void updateBook(Long id,Book book) {
        dao.update(id, book);
    }

    public void deleteBook(Long id) {
        dao.delete(id);
    }

    public void addMap(Map<Long, Book> map) {
        dao.addMap(map);
    }
}
