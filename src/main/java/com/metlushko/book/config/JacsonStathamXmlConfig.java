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

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.metlushko.book")
public class JacsonStathamXmlConfig {
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
            e.printStackTrace();;
        }throw new RuntimeException();
    }





}
