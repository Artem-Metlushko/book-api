package com.metlushko.book.service;

import com.metlushko.book.dto.PersonDtoRegistration;
import com.metlushko.book.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PersonService personService;


    public User registrationPerson(PersonDtoRegistration personDtoRegistration) {
        return personService.savePerson(personDtoRegistration);

    }
}
