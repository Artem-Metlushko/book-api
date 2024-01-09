package com.metlushko.book.dao;

import com.metlushko.book.config.DataCSV;
import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class BookDaoCsv {

    private final Map<Long,Book> map;
    private final DataCSV dataCSV;
    @Value("${random.min}")
    private Long min;

    @Value("${random.max}")
    private Long max;
    private final Random random;



    public List<Map.Entry<Long, Book>> getAllBooks() {
        return dataCSV.loadBooks().entrySet().stream().toList();
    }


    public Book getBookById(Long id) {
        return dataCSV.loadBooks().get(id);
    }


    public void addBook(Book book) {
        Map<Long, Book> bookMap = dataCSV.loadBooks();

        long id = random.nextLong((max - min + 1) + min);
        book.setId(id);
        bookMap.put(book.getId(),book);

        dataCSV.writeBooks(bookMap);


    }


    public void updateBook(Book book) {
        Map<Long, Book> bookMap = dataCSV.loadBooks();

        if (bookMap.containsKey(book.getId())) {
            bookMap.put(book.getId(), book);

            dataCSV.writeBooks(bookMap);
        } else {
            throw new IllegalArgumentException("Book with id " + book.getId() + " not found.");
        }
    }

    public void deleteBook(Long id) {
        Map<Long, Book> bookMap = dataCSV.loadBooks();

        if (bookMap.containsKey(id)) {
            bookMap.remove(id);

            dataCSV.writeBooks(map);
        } else {
            throw new IllegalArgumentException("Book with id " + id + " not found.");
        }

    }

    public void addMap(Map<Long, Book> bookMap){

        map.putAll(bookMap);
    }
}
