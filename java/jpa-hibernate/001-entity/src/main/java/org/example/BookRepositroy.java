package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


public class BookRepositroy {

    private EntityManager entityManager;
    public BookRepositroy(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void addBook(Books book) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(book);
        this.entityManager.getTransaction().commit();
    }

    public Books getBook(Long bookId) {
        entityManager.getTransaction().begin();
        Books book = entityManager.find(Books.class, bookId);
        entityManager.getTransaction().commit();
        return book;
    }
    public void removeBook(Long bookId) {
        entityManager.getTransaction().begin();

        Books book = entityManager.find(Books.class, bookId);

        if (book != null) {
            entityManager.remove(book);
        }
        entityManager.getTransaction().commit();
    }
}
