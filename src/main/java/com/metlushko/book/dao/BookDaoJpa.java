package com.metlushko.book.dao;

import com.metlushko.book.entyti.Book;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookDaoJpa implements Dao{

    private final SessionFactory sessionFactory;

    public Optional<Book> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Book book = session.get(Book.class, id);

        return Optional.ofNullable(book);
    }

    public Book save(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        Long id = book.getId();

        return session.get(Book.class,id);

    }

    public void update(Long id, Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book bookForUpdate = session.get(Book.class, id);

        bookForUpdate.setAuthor(book.getAuthor());
        bookForUpdate.setDescription(book.getDescription());
        bookForUpdate.setName(book.getName());


    }

    public void delete(Long id){
        Session session = sessionFactory.getCurrentSession();

        Book book = session.get(Book.class, id);
        session.remove(book);
    }

    @Override
    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();

       return session.createQuery("select b from Book b", Book.class).getResultList();


    }


}
