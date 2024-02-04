package com.metlushko.book.controller.rest;

import com.metlushko.book.dto.BookRequestDto;
import com.metlushko.book.dto.BookResponseDto;
import com.metlushko.book.entity.Book;
import com.metlushko.book.entity.Image;
import com.metlushko.book.service.ImageService;
import com.metlushko.book.service.rest.BookServiceRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/books")
public class BookControllerRest {

    private final BookServiceRest bookService;
    private final ImageService imageService;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto addBook(@Valid @RequestBody BookRequestDto bookResponseDto) {
         return bookService.addBook(bookResponseDto);
    }

    @PutMapping("{id}")
    public BookResponseDto update(@PathVariable("id") Long id,
                                  @Valid @RequestBody BookRequestDto bookRequestDto) {
        return bookService.updateBook(id, bookRequestDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        if (!bookService.deleteBook(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addImage(@RequestParam("image") MultipartFile image) {

        return new ResponseEntity<>(bookService.saveImage(image), HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable("id") String id) throws IOException {
        Image imageLoad = imageService.download(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageLoad.getFileType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageLoad.getName() + "\"")
                .body(new ByteArrayResource(imageLoad.getFile()));
    }


}
