package com.metlushko.book.entyti;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
//@Cacheable
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@JsonPropertyOrder({"id", "name", "author", "description"})
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String author;

    private String description;


}
