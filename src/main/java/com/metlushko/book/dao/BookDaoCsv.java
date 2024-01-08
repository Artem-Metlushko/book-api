package com.metlushko.book.dao;

import com.metlushko.book.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookDaoCsv implements BookDao {

    private List<Book> bookList=new ArrayList<>();

    private final String CSV_FILE_PATH = "src/main/resources/book.csv";
//    private final CsvMapper csvMapper = new CsvMapper();
//    private final CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();


/*    @Override
    public  <T> List<T> getAllBooks()  {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new File(CSV_FILE_PATH);
            MappingIterator<T> readValues =
                    mapper.readerFor(Book.class)
                            .with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
           e.printStackTrace();
            return Collections.emptyList();
        }
    }*/


    @Override
    public  List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Long id) {

    }
}
