package com.metlushko.book.dao;

import com.metlushko.book.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookDaoJpa implements CriteriaDao {

    private final SessionFactory sessionFactory;

    @Cacheable(value="bookCache", key="#id")
    public Optional<Book> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Book book = session.get(Book.class, id);

        return Optional.ofNullable(book);
    }

    public Book save(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        Long id = book.getId();

        return session.get(Book.class, id);

    }

    public void update(Long id, Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book bookForUpdate = session.get(Book.class, id);

        bookForUpdate.setAuthor(book.getAuthor());
        bookForUpdate.setDescription(book.getDescription());
        bookForUpdate.setName(book.getName());


    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Book book = session.get(Book.class, id);
        session.remove(book);
    }

    public List<Book> findAll(String author, String name) {
        Session session = sessionFactory.getCurrentSession();

        try (EntityManager entityManager = sessionFactory.createEntityManager()
        ) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

            Root<Book> book = criteriaQuery.from(Book.class);
            List<Predicate> predicates = new ArrayList<>();

            if (author != null) {
                predicates.add(criteriaBuilder.equal(book.get("author"), author));
            }

            if (name != null) {
                predicates.add(criteriaBuilder.equal(book.get("name"), name));
            }

            criteriaQuery.where(predicates.toArray(new Predicate[0]));

            return entityManager.createQuery(criteriaQuery).getResultList();
        }

    }

    @Override
    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select b from Book b", Book.class).getResultList();


    }


}
