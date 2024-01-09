package com.metlushko.book;

import com.metlushko.book.config.AppConfig;
import com.metlushko.book.config.DataCSV;
import com.metlushko.book.controller.BookController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataCSV csv = context.getBean(DataCSV.class);
        System.out.println(csv);



        BookController bookController = context.getBean(BookController.class);
        bookController.main();


    }

}
