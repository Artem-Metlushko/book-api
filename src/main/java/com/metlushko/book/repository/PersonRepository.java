package com.metlushko.book.repository;

import com.metlushko.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
