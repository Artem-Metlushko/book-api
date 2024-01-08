package com.metlushko.book;

import com.fasterxml.jackson.databind.MappingIterator;
import com.metlushko.book.config.JacsonStathamXmlConfig;
import com.metlushko.book.dao.BookDao;
import com.metlushko.book.dao.BookDaoCsv;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.IOException;

public class BookApiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JacsonStathamXmlConfig.class);
        BookDaoCsv bookDaoCsv = context.getBean(BookDaoCsv.class);
        System.out.println(bookDaoCsv.getAllBooks());


    }

}
