package com.metlushko.book.config;

import com.metlushko.book.model.Book;
import com.metlushko.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Setup {

    private final SetupData setupData;

    private final BookService bookService;

    @PostConstruct
    private void setupData(){
        setupBookList();

    }

    private void setupBookList(){
        List<Book> books = setupData.getBooks();
        for (Book book:books){
            bookService.addBook(book);
        }

    }



}
