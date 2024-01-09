package com.metlushko.book.config;

import com.metlushko.book.model.Book;
import com.metlushko.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SetupInMemory {

    private final SetupData setupData;

    private final BookService bookService;

    private final File file;

    @PostConstruct
    private void setupData(){
        setupBookListInMemory();

    }

    private void setupBookListInMemory(){
        List<Book> books = setupData.loadObjectList(Book.class, file.getAbsolutePath());
        for (Book book:books){
            bookService.addBook(book);
        }
    }




}
