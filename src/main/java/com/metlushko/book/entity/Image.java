package com.metlushko.book.entity;

import lombok.Data;

@Data
public class Image {

    private String name;
    private String fileType;
    private byte[] file;
}
