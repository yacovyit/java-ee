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
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            // Initiate person
            Person person = new Person();
            person.setFirstName("John");
            person.setLastName("Doe");

            // Initiate address
            Address address = new Address();
            address.setStreet("123 Main St");
            address.setCity("New York");
            address.setZipCode("122333");

            // Associate person with address
            person.setAddress(address);

            // Save person to the database
            entityManager.persist(person);
            entityManager.getTransaction().commit();
        }
    }
}
