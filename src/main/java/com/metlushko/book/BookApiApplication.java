package com.metlushko.book;

import com.metlushko.book.config.AppConfig;
import com.metlushko.book.dao.BookDaoCsv;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookDaoCsv bookDaoCsv = context.getBean(BookDaoCsv.class);

//        Book book = new Book( "1", "1", "1");
//        bookDaoCsv.addBook(book);
//        System.out.println(bookDaoCsv.getAllBooks());

//        BookController bookController = context.getBean(BookController.class);
//        bookController.main();


    }

}
