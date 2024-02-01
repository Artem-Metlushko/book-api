package com.metlushko.book.dao;

import com.metlushko.book.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookDaoCsv implements Dao {

    private final DataCSV dataCSV;
    @Value("${random.min}")
    private Long min;

    @Value("${random.max}")
    private Long max;
    private final Random random;

    @Override
    public List<Book> findAll() {
        return dataCSV.loadBooks().values().stream()
                .collect(Collectors.toList());
    }



    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(dataCSV.loadBooks().get(id));
    }

    @Override
    public Book save(Book book) {
        Map<Long, Book> bookMap = dataCSV.loadBooks();

        long id = random.nextLong((max - min + 1) + min);
        book.setId(id);
        bookMap.put(book.getId(), book);

        dataCSV.writeBooks(bookMap);
        return dataCSV.loadBooks().get(id);

    }


    @Override
    public void update(Long id, Book book) {
        Map<Long, Book> bookMap = dataCSV.loadBooks();

        if (bookMap.containsKey(book.getId())) {
            bookMap.put(book.getId(), book);

            dataCSV.writeBooks(bookMap);
        } else {
            throw new IllegalArgumentException("Book with id " + book.getId() + " not found.");
        }
    }

    @Override
    public void delete(Long id) {
        Map<Long, Book> bookMap = dataCSV.loadBooks();

        if (bookMap.containsKey(id)) {
            bookMap.remove(id);

            dataCSV.writeBooks(bookMap);
        } else {
            throw new IllegalArgumentException("Book with id " + id + " not found.");
        }

    }


}
