package com.metlushko.book.config;

import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SetupData {

    public final static String BOOK_CSV ="book.csv";

    private final CsvDataLoader csvDataLoader;

    public List<Book> getBooks(){
        return csvDataLoader.loadObjectList(Book.class,BOOK_CSV);
    }
}
