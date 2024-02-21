package com.metlushko.book.mapper;

import com.metlushko.book.dto.PersonDtoRegistration;
import com.metlushko.book.dto.PersonDtoResponse;
import com.metlushko.book.entity.User;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonDtoResponse toPersonDtoResponse(User user){
        return PersonDtoResponse.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    public User toPerson(PersonDtoRegistration personDtoRegistration){
        return User.builder()
                .username(personDtoRegistration.getUsername())
                .password(personDtoRegistration.getPassword())
                .role(personDtoRegistration.getRole())
                .build();
    }
}
