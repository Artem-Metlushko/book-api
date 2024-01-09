package com.metlushko.book.dao;

import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@RequiredArgsConstructor
public class BookDaoCsv implements BookDao {

    private final List<Book> bookList;


    @Override
    public  List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Long id) {

    }
}
