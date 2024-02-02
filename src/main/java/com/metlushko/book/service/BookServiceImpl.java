package com.metlushko.book.service;

import com.metlushko.book.dao.CriteriaDao;
import com.metlushko.book.dao.Dao;
import com.metlushko.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl {

    private final Dao dao;
    private final CriteriaDao criteriaDao;

    @Autowired
    public BookServiceImpl(@Qualifier("bookDaoJpa") Dao dao ,
                          CriteriaDao criteriaDao
    ) {
        this.dao = dao;
        this.criteriaDao = criteriaDao;
    }


    public List<Book> getAllBooks() {
        return dao.findAll();
    }

    public List<Book> getAllBooks(String author, String name) {

        return criteriaDao.findAll(author, name);

    }


    public Book getBookById(Long id) {
        return dao.findById(id).orElseThrow();
    }

    public Book addBook(Book book) {
        return dao.save(book);
    }

    public void updateBook(Long id, Book book) {
        dao.update(id, book);
    }

    public void deleteBook(Long id) {
        dao.delete(id);
    }


}
