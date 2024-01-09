package com.metlushko.book.dao;

import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class BookDaoCsv implements BookDao {

    private final List<Book> bookList;
    @Value("${random.min}")
    private Long min;

    @Value("${random.max}")
    private Long max;
    private final Random random;


    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public Book getBookById(Long id) {
        int parseInt = Integer.parseInt(String.valueOf(id));
        return bookList.get(parseInt);
    }

    @Override
    public void addBook(Book book) {
        long id = random.nextLong((max - min + 1) + min);
        book.setId(id);
//        bookMap.add(book);

    }

    @Override
    public void updateBook(Book book) {



    }

    @Override
    public void deleteBook(Long id) {

    }
}
