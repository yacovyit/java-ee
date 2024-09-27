package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.flight.Flight;
import org.example.flight.Passenger;
import org.example.flight.Ticket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.printf("Hello and welcome!");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");

        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();

            // Here is our code ....
            System.out.println("In our transaction ...");

            // Flight declaration and creation
            Flight flight = new Flight(1L, "FL1234");

            // Passenger declaration and creation
            Passenger alice = new Passenger(1L, "Alice", "Crypto");
            Passenger bob = new Passenger(2L, "Bob", "Crypto");

            // Adding passengers to the flight
            flight.addPassenger(alice);
            flight.addPassenger(bob);

            // Setting the flight to the passengers
            alice.setFlight(flight);
            bob.setFlight(flight);

            // Ticket declaration and creation
            Ticket aliceTicket = new Ticket(1L, "DTK001");
            Ticket bobTicket = new Ticket(2L, "DTK002");

            // Adding tickets to the passengers
            alice.addTicket(aliceTicket);
            bob.addTicket(bobTicket);

            // Setting the passengers to the tickets
            aliceTicket.setPassenger(alice);
            bobTicket.setPassenger(bob);

            // Persisting entities to the database
            entityManager.persist(flight);
            entityManager.persist(alice);
            entityManager.persist(bob);
            entityManager.persist(aliceTicket);
            entityManager.persist(bobTicket);

            transaction.commit();
            System.out.println("Transaction completed successfully.");
        }


    }
}
