package com.metlushko.book.service.rest;

import com.metlushko.book.dto.BookResponseDto;
import com.metlushko.book.entity.Book;
import com.metlushko.book.repository.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class BookServiceRest {

    private final BookRepository bookRepository;

    public BookServiceRest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponseDto> getAllBooks() {

        return bookRepository.findAll().stream()
                .map(book -> new BookResponseDto(book.getName(), book.getAuthor(), book.getDescription()))
                .collect(Collectors.toList());
    }

    public List<BookResponseDto> getAllBooks(String author, String name) {

        return bookRepository.findAll().stream()
                .map(book -> new BookResponseDto(book.getName(), book.getAuthor(), book.getDescription()))
                .collect(Collectors.toList());

    }


    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

/*    public void updateBook(Long id, BookRequestDto bookRequestDto) {
        Optional<Book> byId = bookRepository.findById(id);
        byId.map(book -> new BookResponseDto())

    }

    public void deleteBook(Long id) {
        dao.delete(id);
    }*/


}
