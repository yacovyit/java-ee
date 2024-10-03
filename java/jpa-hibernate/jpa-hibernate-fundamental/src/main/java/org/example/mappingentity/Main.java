package org.example.mappingentity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            // Here is our code ....
            System.out.println("In our transaction ...");
            // persist new books
            entityManager.getTransaction().begin();
            entityManager.persist(new Student( "John", "Doe", "47 W 13th St, New York, NY 10011, USA", LocalDate.of(1980, 1, 1), "Biography", Language.ENGLISH));
            entityManager.persist(new Student( "Jane", "Smith", "98 Kingsway London N85 3VH, UK", LocalDate.of(1991, 2, 18), "Biography", Language.ENGLISH));
            entityManager.persist(new Student( "Eli", "yahoo", "29 Salah a-Din Street, 9149001 Jerusalem, IL", LocalDate.of(1975, 3, 15), "Biography", Language.ENGLISH));
            entityManager.getTransaction().commit();
        }
    }
}