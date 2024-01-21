package com.metlushko.book.service;

import com.metlushko.book.dao.Dao;
import com.metlushko.book.entyti.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class BookServiceImpl  {

    private final Dao dao;

    @Autowired
    public BookServiceImpl(@Qualifier("bookDaoJpa") Dao dao) {
        this.dao = dao;
    }


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

}
