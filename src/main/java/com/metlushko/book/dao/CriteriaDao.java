package com.metlushko.book.dao;

import com.metlushko.book.entity.Book;

import java.util.List;

public interface CriteriaDao extends Dao {
    List<Book> findAll(String author, String name);
}
