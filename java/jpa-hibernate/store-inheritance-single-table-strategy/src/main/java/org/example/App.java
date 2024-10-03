package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

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

            // Initiate DVD
            DVD dvd = new DVD();
            dvd.setTitle("Star Wars: Episode IV - A New Hope");
            dvd.setGenre(Genre.SCI_FI);
            dvd.setReleaseDate(LocalDate.of(1977, 5, 25));
            dvd.setTotalDuration(149.85f);
            dvd.setQuantity(1);
            dvd.setUnitPrice(12.99f);

            // Initiate Book
            Book book = new Book();
            book.setAuthor("Issac Asimov");
            book.setTitle("Foundation");
            book.setUnitPrice(9.99f);
            book.setQuantity(2);
            book.setPublicationDate(LocalDate.of(1955, 7, 21));
            book.setPageCount(336);

            // Initiate item
            Item item = new Item();
            item.setTitle("Bazzoka");
            item.setQuantity(5);
            item.setUnitPrice(5.99f);
            item.setDescription("A generic item");

            // Save to DB
            entityManager.persist(book);
            entityManager.persist(dvd);
            entityManager.persist(item);

            // Commit changes
            entityManager.getTransaction().commit();
        }
    }
}
