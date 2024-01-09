package com.metlushko.book.service;

import com.metlushko.book.dao.BookDaoCsv;
import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDaoCsv bookDaoCsv;

    @Override
    public List<Map.Entry<Long, Book>> getAllBooks() {
        return bookDaoCsv.getAllBooks();
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    public void addBook(Book book){


        bookDaoCsv.addBook(book);
    }

    public void updateBook(Book book) {
        bookDaoCsv.updateBook(book);
    }

    public void deleteBook(Long id) {
        bookDaoCsv.deleteBook(id);
    }
    public void addMap(Map<Long,Book> map){
        bookDaoCsv.addMap(map);


    }


}
