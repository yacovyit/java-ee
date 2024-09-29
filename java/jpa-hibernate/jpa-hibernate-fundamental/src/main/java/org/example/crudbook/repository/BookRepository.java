package org.example.crudbook.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.crudbook.entity.Book;

public class BookRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.transaction = entityManager.getTransaction();
    }

    public void persist(Book book) {
        this.transaction.begin();
        entityManager.persist(book);
        this.transaction.commit();
    }



    public void update(Book book) {
        this.transaction.begin();
        entityManager.merge(book);
        this.transaction.commit();
    }

    public Book find(long bookId) {
        Book book = entityManager.find(Book.class, bookId);
        return book;
    }

    public void remove(Book book) {
        transaction.begin();
        Book mergeBook = entityManager.merge(book);
        if (mergeBook!= null) {
            entityManager.remove(book);
        }
        transaction.commit();
    }

    public void removeById(Long id) {
        Book book = entityManager.find(Book.class, id);
        if (book!= null) {
            transaction.begin();
            entityManager.remove(book);
            transaction.commit();
        }
    }


}
