package com.metlushko.book.dao;

import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class BookDaoCsv {

    private final Map<Long,Book> map=new HashMap<>();
    @Value("${random.min}")
    private Long min;

    @Value("${random.max}")
    private Long max;
    private final Random random;



    public List<Map.Entry<Long, Book>> getAllBooks() {
        return map.entrySet().stream().toList();
    }


 /*   public Book getBookById(Long id) {
        int parseInt = Integer.parseInt(String.valueOf(id));
        return bookList.get(parseInt);
    }*/


    public void addBook(Book book) {
        long id = random.nextLong((max - min + 1) + min);
        book.setId(id);
        map.put(book.getId(),book);
    }


    public void updateBook(Book book) {

    }

    public void deleteBook(Long id) {

    }

    public void addMap(Map<Long, Book> bookMap){

        map.putAll(bookMap);
    }
}
