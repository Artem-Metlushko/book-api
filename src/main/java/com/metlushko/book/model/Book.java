package com.metlushko.book.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonPropertyOrder({"id","name","author","description"})
public class Book {

    private Long id;
    private String name;
    private String author;
    private String description;

}
