package com.metlushko.book.config;

import com.metlushko.book.model.Book;
import com.metlushko.book.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SetupInMemory {

    private final SetupData setupData;

    private final BookServiceImpl bookService;


    @PostConstruct
    private void setupData(){
//        addBookToMemoryFromCsvFile();
        mapSout();


    }

    private void addBookToMemoryFromCsvFile(){
        List<Book> books = setupData.loadObjectList(Book.class);

        for (Book book:books){
            bookService.addBook(book);
        }
    }

    private void mapSout(){
        Map<Long, Book> map = setupData.loadObjectMap(Book.class);
        map.entrySet().forEach(System.out::println);
    }




}
