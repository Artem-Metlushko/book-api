package com.metlushko.book.config;

import com.metlushko.book.dao.DataCSV;
import com.metlushko.book.entity.Book;
import com.metlushko.book.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SetupInMemoryCsvProvider {

    private final DataCSV dataCSV;

    private final BookServiceImpl bookService;

    private final  Map<Long, Book> hashMap;


    @PostConstruct
    private void setupData(){

        hashMap.put(1L,Book.builder()
                .id(1L)
                .author("author1")
                .name("name1")
                .description("description1")
                .build());
        hashMap.put(2L,Book.builder()
                .id(2L)
                .author("author2")
                .name("name2")
                .description("description2")
                .build());
        hashMap.put(3L,Book.builder()
                .id(3L)
                .author("author3")
                .name("name3")
                .description("description3")
                .build());

        dataCSV.writeBooks(hashMap);

        dataCSV.loadBooks();

    }


}
