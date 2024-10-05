package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();


            // Create a new book
            Person person = new Student("Math 101");
            person.setFirstName("Michael");
            person.setLastName("Jordan");
            person.setBirthDateTime(java.time.LocalDateTime.of(1963, 2, 17, 1, 12, 1));

            // Save the book
            entityManager.persist(person);

            // Commit the transaction
            entityManager.getTransaction().commit();

            System.out.println(person);

        }
    }
}
