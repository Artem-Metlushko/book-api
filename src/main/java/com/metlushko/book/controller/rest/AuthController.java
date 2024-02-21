package com.metlushko.book.controller.rest;

import com.metlushko.book.dto.PersonDtoRegistration;
import com.metlushko.book.entity.User;
import com.metlushko.book.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public User registration(@RequestBody PersonDtoRegistration personDtoRegistration){
        return authService.registrationPerson(personDtoRegistration);
    }

}
