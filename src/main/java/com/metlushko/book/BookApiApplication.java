package com.metlushko.book;

import com.metlushko.book.config.CsvConfig;
import com.metlushko.book.service.BookServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CsvConfig.class);

      /*  BookController bookController = context.getBean(BookController.class);
        bookController.main();*/

       /* BookDaoJdbc bookDaoJdbc = context.getBean(BookDaoJdbc.class);
        bookDaoJdbc.getBooks().forEach(System.out::println);
        System.out.println(bookDaoJdbc.findById(11L));
        bookDaoJdbc.save(new Book("saveBook","saveBook","saveBook"));
        Book book = new Book("updateBook", "updateBook", "updateBook");
        bookDaoJdbc.update(11L,book );
        bookDaoJdbc.delete(1L);
        bookDaoJdbc.findAll().forEach(System.out::println);*/

        BookServiceImpl bookService = context.getBean(BookServiceImpl.class);
        System.out.println(bookService.getBookById(11L));
        System.out.println(bookService.getBookById(11L));
        /*Book bookForUpdate = new Book("updateBook", "updateBook", "updateBook");
        Book bookForSave = new Book("saveBook", "saveBook", "saveBook");
        bookService.updateBook(11L, bookForUpdate);
        bookService.addBook(bookForSave);
        bookService.deleteBook(1L);
        bookService.getAllBooks().forEach(System.out::println);
        bookService.getAllBooks("saveBook","saveBook").forEach(System.out::println);*/


    }


}
