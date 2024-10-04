package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
                entityManager.getTransaction().begin();

                Author issacAsimov = new Author("Issac", "Asimov");
                Book foundation = new Book("Foundation", "978-0441154860", 28f, LocalDate.of(1951,1,1), 28, Genre.SCI_FI);
                foundation.addAuthor(issacAsimov);

                entityManager.persist(issacAsimov);
                entityManager.persist(foundation);

                entityManager.getTransaction().commit();

        }
    }
}
