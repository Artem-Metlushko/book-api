package com.metlushko.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dummy {

    @GetMapping("/h")
    public String sayHello() {
        return "hello_world";
    }
}
