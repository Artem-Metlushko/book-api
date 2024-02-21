/*
package com.metlushko.book.controller;

import com.metlushko.book.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {


        @GetMapping("/hello")
        public String sayHello() {
            return "hello";
        }

        @GetMapping("/showUserInfo")
        public PersonDetails showUserInfo() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
            System.out.println(personDetails.getPerson());

            return personDetails;
        }
    }
*/
