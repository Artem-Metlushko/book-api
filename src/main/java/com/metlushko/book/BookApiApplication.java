package com.metlushko.book;

import com.metlushko.book.config.CsvConfig;
import com.metlushko.book.controller.BookController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CsvConfig.class);

        BookController bookController = context.getBean(BookController.class);
        bookController.main();


    }

}
