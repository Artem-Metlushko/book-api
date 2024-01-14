package com.metlushko.book.dao;

import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookDaoJdbc {

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<Book> propertyRowMapper;


    private static final String FIND_ALL = "SELECT * FROM books";

    private static final  String FIND_BY_ID = "SELECT * FROM books WHERE id=?";


    public List<Book> getBooks() {
        return jdbcTemplate.query(FIND_ALL, propertyRowMapper);
    }

    public Book findById(Long id) {

        return  jdbcTemplate.query(FIND_BY_ID, propertyRowMapper,new Object[]{id})
                .stream()
                .findAny()
                .orElseThrow();
    }
}
