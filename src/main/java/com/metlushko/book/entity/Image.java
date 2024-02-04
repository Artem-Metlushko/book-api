package com.metlushko.book.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;

@Data
@Document(collection = "books")
public class Image {

    private String name;
    private InputStream stream;

}
