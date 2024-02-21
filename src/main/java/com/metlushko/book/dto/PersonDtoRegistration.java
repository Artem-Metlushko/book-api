package com.metlushko.book.dto;

import lombok.Data;

@Data
public class PersonDtoRegistration {

    private String username;
    private String password;
    private String email;
    private String role;

}
