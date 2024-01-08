package com.metlushko.book.service;

import com.metlushko.book.dao.BookDaoCsv;
import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {

    private final BookDaoCsv bookDaoCsv;

    public List<Book> getBooks(){
       return bookDaoCsv.getAllBooks();
    }

    public void addBook(Book book){
        bookDaoCsv.addBook(book);
    }


}
