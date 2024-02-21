package com.metlushko.book.service;

import com.metlushko.book.dto.PersonDtoRegistration;
import com.metlushko.book.entity.User;
import com.metlushko.book.mapper.PersonMapper;
import com.metlushko.book.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonMapper personMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final PersonRepository personRepository;


    public User savePerson(PersonDtoRegistration personDtoRegistration) {
        User user = personMapper.toPerson(personDtoRegistration);

        String password = user.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(encodePassword);

        return personRepository.save(user);


    }

        public Long savePerson(User user){
        String password = user.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(encodePassword);
        User saveUser = personRepository.save(user);
        return saveUser.getId();

    }

}
