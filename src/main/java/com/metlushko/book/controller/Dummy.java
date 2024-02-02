package com.metlushko.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dummy {

    @GetMapping("/h")
    public String sayHello(ModelMap model) {
        return "hello_world";
    }
}
