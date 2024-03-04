package com.metlushko.book.mapper;

import com.metlushko.book.dto.SignUpDto;
import com.metlushko.book.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(SignUpDto signUpDto ){

        return User.builder()
                .username(signUpDto.getUsername())
                .email(signUpDto.getEmail())
                .password(signUpDto.getPassword())
                .build();
    }
}
