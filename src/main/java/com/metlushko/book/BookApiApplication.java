package com.metlushko.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookApiApplication {

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CsvConfig.class);
        ConfigurableApplicationContext context = SpringApplication.run(BookApiApplication.class, args);
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

        /*BBookServiceImpl bookService = context.getBean(BookServiceImpl.class);
        System.out.println(bookService.getBookById(11L));
        System.out.println(bookService.getBookById(11L));
        ook bookForUpdate = new Book("updateBook", "updateBook", "updateBook");
        Book bookForSave = new Book("saveBook", "saveBook", "saveBook");
        bookService.updateBook(11L, bookForUpdate);
        bookService.addBook(bookForSave);
        bookService.deleteBook(1L);
        bookService.getAllBooks().forEach(System.out::println);
        bookService.getAllBooks("saveBook","saveBook").forEach(System.out::println);*/

        /*BookControllerRest bookControllerRest = context.getBean(BookControllerRest.class);
        Book bookById = bookControllerRest.getBookById(11L);
        System.out.println(bookById);*/




    }


}
