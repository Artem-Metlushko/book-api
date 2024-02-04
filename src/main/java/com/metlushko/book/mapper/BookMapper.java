package com.metlushko.book.mapper;

import com.metlushko.book.dto.BookRequestDto;
import com.metlushko.book.dto.BookResponseDto;
import com.metlushko.book.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toBook(BookRequestDto bookRequestDto) {
        return Book.builder()
                .author(bookRequestDto.author())
                .name(bookRequestDto.name())
                .description(bookRequestDto.description())
                .build();
    }


    public BookResponseDto toBookResponseDto(Book book) {
        return new BookResponseDto(book.getName(), book.getAuthor(), book.getDescription());
    }

    public BookRequestDto toBookRequestDto(Book book) {
        return new BookRequestDto(book.getName(), book.getAuthor(), book.getDescription());
    }

    /*public Book toCopyBook(Book book) {
        return Book.builder()
                .author(book.getAuthor())
                .name(book.getName())
                .description(book.getDescription())
                .build();
    }*/

    public Book toCopyBook(Book book, BookRequestDto bookRequestDto) {
        return Book.builder()
                .id(book.getId())
                .author(bookRequestDto.author())
                .name(bookRequestDto.name())
                .description(bookRequestDto.description())
                .build();

    }

}
