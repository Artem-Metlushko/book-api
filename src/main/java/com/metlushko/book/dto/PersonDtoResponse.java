package com.metlushko.book.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDtoResponse {

    private String username;
    private String password;
    private String role;


}
