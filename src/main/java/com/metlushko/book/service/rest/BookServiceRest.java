package com.metlushko.book.service.rest;

import com.metlushko.book.dto.BookRequestDto;
import com.metlushko.book.dto.BookResponseDto;
import com.metlushko.book.entity.Book;
import com.metlushko.book.mapper.BookMapper;
import com.metlushko.book.repository.BookRepository;
import com.metlushko.book.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceRest {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    private final ImageService imageService;


    public List<BookResponseDto> getAllBooks() {

        return bookRepository.findAll(PageRequest.of(1, 2, Sort.by("id")))
                .stream()
                .map(bookMapper::toBookResponseDto)
                .toList();
    }


    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @SneakyThrows
    @Transactional
    public BookResponseDto addBook(BookRequestDto bookRequestDto, MultipartFile imageFile) {

        String id = !imageFile.isEmpty() ? imageService.addImage(imageFile) : null;
        return addBookInternal(bookRequestDto, id);
    }

    @Transactional
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        return addBookInternal(bookRequestDto, null);
    }

    private BookResponseDto addBookInternal(BookRequestDto bookRequestDto, String id) {
        return Optional.of(bookRequestDto)
                .map(book -> bookMapper.toBook(bookRequestDto, id))
                .map(bookRepository::save)
                .map(bookMapper::toBookResponseDto)
                .orElseThrow();
    }


    @Transactional
    public Optional<BookResponseDto> updateBook(Long id, BookRequestDto bookRequestDto) {

        return bookRepository.findById(id)
                .map(book -> bookMapper.toCopyBook(book, bookRequestDto))
                .map(bookRepository::saveAndFlush)
                .map(bookMapper::toBookResponseDto);

    }

    @Transactional
    public boolean deleteBook(Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    bookRepository.delete(book);
                    bookRepository.flush();
                    return true;
                }).orElse(false);
    }



}
