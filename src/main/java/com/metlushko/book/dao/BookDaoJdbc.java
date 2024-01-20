package com.metlushko.book.dao;

import com.metlushko.book.entyti.Book;
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

    private static final String FIND_BY_ID = "SELECT * FROM books WHERE id=?";

    private static final String SAVE = "INSERT INTO books(id,name,author,description) VALUES(?, ?, ?, ?)";

    public static final String UPDATE = "UPDATE books SET name=?, author=?, description=? WHERE id=?";

    public static final String DELETE = "DELETE FROM books WHERE id=?";
    public List<Book> getBooks() {
        return jdbcTemplate.query(FIND_ALL, propertyRowMapper);
    }

    public Book findById(Long id) {

        return jdbcTemplate.query(FIND_BY_ID, propertyRowMapper, new Object[]{id})
                .stream()
                .findAny()
                .orElseThrow();
    }

    public void save(Book book) {
        int update = jdbcTemplate.update(SAVE, book.getId(), book.getName(), book.getAuthor(), book.getDescription());
    }

    public void update(Long id, Book book) {
        jdbcTemplate.update(UPDATE,book.getName(), book.getAuthor(), book.getDescription(),book.getId() );
    }

    public void delete(Long id){
        jdbcTemplate.update(DELETE,id);

    }


}
