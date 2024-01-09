package com.metlushko.book.config;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.metlushko.book")
public class AppConfig {
    @Value("${jacson.path}")
    private String fileName;


    @Bean
    public CsvMapper csvMapper(){
        return new CsvMapper();
    }

    @Bean
    public File file() {
        try {
            return new ClassPathResource(fileName).getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }throw new RuntimeException();
    }

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

    @Bean()
    public Random random(){
        return new Random();

    }


}
