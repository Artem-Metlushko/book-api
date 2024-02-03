package com.metlushko.book.service.rest;

import com.metlushko.book.dto.BookRequestDto;
import com.metlushko.book.dto.BookResponseDto;
import com.metlushko.book.entity.Book;
import com.metlushko.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceRest {

    private final BookRepository bookRepository;


    public List<BookResponseDto> getAllBooks() {

        return bookRepository.findAll().stream()
                .map(book -> new BookResponseDto(book.getName(), book.getAuthor(), book.getDescription()))
                .toList();
    }

    public List<BookResponseDto> getAllBooks(String author, String name) {

        return bookRepository.findAll().stream()
                .map(book -> new BookResponseDto(book.getName(), book.getAuthor(), book.getDescription()))
                .toList();

    }


    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }
    @Transactional
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {

        return Optional.of(bookRequestDto)
                .map(book -> new Book(null, bookRequestDto.name(), bookRequestDto.author(), bookRequestDto.description()))
                .map(bookRepository::save)
                .map(bookResponceDto -> new BookResponseDto(bookRequestDto.name(), bookRequestDto.author(), bookRequestDto.description()))
                .orElseThrow();

    }
    @Transactional
    public Optional<BookResponseDto> updateBook(Long id, BookRequestDto bookRequestDto) {

        return bookRepository.findById(id)
                .map(book -> new Book(null, bookRequestDto.name(), bookRequestDto.author(), bookRequestDto.description()))
                .map(bookRepository::saveAndFlush)
                .map(bookResponceDto -> new BookResponseDto(bookRequestDto.name(), bookRequestDto.author(), bookRequestDto.description()));
    }

    @Transactional
    public boolean deleteBook(Long id) {
        return bookRepository.findById(id)
                .map( book -> {
                    bookRepository.delete(book);
                    bookRepository.flush();
                    return true;
                }).orElse(false);
    }


}
