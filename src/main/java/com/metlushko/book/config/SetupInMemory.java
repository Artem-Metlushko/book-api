package com.metlushko.book.config;

import com.metlushko.book.model.Book;
import com.metlushko.book.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SetupInMemory {

    private final SetupData setupData;

    private final BookServiceImpl bookService;


    @PostConstruct
    private void setupData(){

        HashMap<Long, Book> hashMap = new HashMap<>();
        hashMap.put(1L,new Book(1L,"2","3","4"));
        hashMap.put(2L,new Book(2L,"2","3","4"));


        writeBooksToCsv(hashMap);
        readBooksFromCsvFile();
        System.out.println(bookService.getAllBooks());


    }

    private void addBookToMemoryFromCsvFile(){
        List<Book> books = setupData.loadObjectList(Book.class);

        for (Book book:books){
            bookService.addBook(book);
        }
    }

    private void readBooksFromCsvFile(){
        Map<Long, Book> map = setupData.loadObjectMap(Book.class);
        bookService.addMap(map);
    }

    private void writeBooksToCsv(Map<Long,Book> map){
        setupData.writeAlLObject(map);
    }




}
