package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
              new InitDB(entityManager).init();
              QueryService queryService = new QueryService(entityManager);

              Long issacAsimoveBooksCount =  queryService.countBooksByAuthorName("Issac", "Asimov");
              System.out.println("Issac Asimov wrote " + issacAsimoveBooksCount + " books.");

              long scienceFictionBooksCount = queryService.countBooksByGenre(Genre.SCI_FI);
              System.out.println("There are " + scienceFictionBooksCount + " science fiction books in the library.");

              List<Book> recentBooks = queryService.getBooksBetweenPublicationYears(1930, 1964);
              System.out.println("Recently published books:");
              for (Book book : recentBooks) {
                  System.out.println(book.getTitle() + " published in " + book.getPublishDate().getYear());
              }

              List<Book> expensiveBooks = queryService.getExpensiveBooks(5, null);
              System.out.println("The most expensive books:");
              for (Book book : expensiveBooks) {
                  System.out.println("[" +book.getTitle() + "] at a price of $" + book.getUnitPrice());
              }
        }
    }
}
