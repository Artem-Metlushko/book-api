package com.metlushko.book;

import com.metlushko.book.config.AppConfig;
import com.metlushko.book.dao.BookDaoJdbc;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      /*  BookController bookController = context.getBean(BookController.class);
        bookController.main();*/

        BeanDefinition template = context.getBeanDefinition("jdbcTemplate");
        BookDaoJdbc bookDaoJdbc = context.getBean(BookDaoJdbc.class);
//        bookDaoJdbc.getBooks().forEach(System.out::println);
        System.out.println(bookDaoJdbc.findById(11L));


    }

}
