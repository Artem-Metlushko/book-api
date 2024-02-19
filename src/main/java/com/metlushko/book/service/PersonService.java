package com.metlushko.book.service;

import com.metlushko.book.entity.Person;
import com.metlushko.book.repository.PersonRepository;
import com.metlushko.book.security.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService implements UserDetailsService {
    private final PersonRepository personRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person person = personRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new PersonDetails(person);
    }

    public Long savePerson(Person person){
        String password = person.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        person.setPassword(encodePassword);
        Person savePerson = personRepository.save(person);
        return savePerson.getId();

    }





}
