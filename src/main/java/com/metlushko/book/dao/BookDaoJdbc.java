package com.metlushko.book.dao;

import com.metlushko.book.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookDaoJdbc implements Dao {

    private final JdbcTemplate jdbcTemplate;
    private final KeyHolder keyHolder;
    private final BeanPropertyRowMapper<Book> propertyRowMapper;

    private static final String FIND_ALL = "SELECT * FROM books";

    private static final String FIND_BY_ID = "SELECT * FROM books WHERE id=?";

    private static final String SAVE = "INSERT INTO books(name,author,description) VALUES(?, ?, ?)";

    public static final String UPDATE = "UPDATE books SET name=?, author=?, description=? WHERE id=?";

    public static final String DELETE = "DELETE FROM books WHERE id=?";

    public List<Book> getBooks() {
        return jdbcTemplate.query(FIND_ALL, propertyRowMapper);
    }

    @Override
    public Optional<Book> findById(Long id) {

        return Optional.of(jdbcTemplate.query(FIND_BY_ID, propertyRowMapper, new Object[]{id})
                .stream()
                .findAny()
                .orElseThrow());
    }

    @Override
    public Book save(Book book) {


        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE, new String[]{"id"});
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getDescription());
            return preparedStatement;
        }, keyHolder);

        if (rowsAffected > 0) {
            long generatedId = Objects.requireNonNull(keyHolder.getKey()).longValue();
            book.setId(generatedId);
            return book;
        } else {

            throw new RuntimeException("Failed to insert book");
        }
    }


    @Override
    public void update(Long id, Book book) {

        int rowsAffected = jdbcTemplate.update(UPDATE, book.getName(), book.getAuthor(), book.getDescription(), id);
        if (rowsAffected == 0) {
            throw new RuntimeException("No book found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE, id);

    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query(FIND_ALL, propertyRowMapper);
    }


}
