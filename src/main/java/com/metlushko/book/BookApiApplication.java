package com.metlushko.book;

import com.metlushko.book.config.CsvConfig;
import com.metlushko.book.entyti.Book;
import com.metlushko.book.service.BookServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CsvConfig.class);

      /*  BookController bookController = context.getBean(BookController.class);
        bookController.main();*/

        /*BeanDefinition template = context.getBeanDefinition("jdbcTemplate");
        BookDaoJdbc bookDaoJdbc = context.getBean(BookDaoJdbc.class);
        bookDaoJdbc.getBooks().forEach(System.out::println);
        System.out.println(bookDaoJdbc.findById(11L));
        bookDaoJdbc.save(new Book(2L,"saveBook","saveBook","saveBook"));
        bookDaoJdbc.update(1L, new Book(1L, "updateBook", "updateBook", "updateBook"));
        bookDaoJdbc.delete(1L);*/

        BookServiceImpl bookService = context.getBean(BookServiceImpl.class);
//        System.out.println(bookService.getBookById(11L));
//        Book bookForUpdate = new Book("updateBook", "updateBook", "updateBook");
        Book bookForSave = new Book("saveBook", "saveBook", "saveBook");
//        bookService.updateBook(11L,bookForUpdate);
        bookService.addBook(bookForSave);
//        bookService.deleteBook(12L);
    }

}
