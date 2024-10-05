package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
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

              LocalDate fromPublicationDate =   LocalDate.of(1950, 1, 1);
              int limit = 2;
              List<Book> expensiveBooks = queryService.getExpensiveBooks(limit, fromPublicationDate);
              System.out.println("The most expensive books:");
              for (Book book : expensiveBooks) {
                  System.out.println("[" +book.getTitle() + "] at a price of $" + book.getUnitPrice());
              }

              List<Book> expensiveBooksByCriteriaBuilder = queryService.getExpensiveBooksByCriteriaBuilder(limit, fromPublicationDate);

              System.out.println("The most expensive books (Criteria Builder):");
              for (Book book : expensiveBooksByCriteriaBuilder) {
                  System.out.println("[" + book.getTitle() + "] at a price of $" + book.getUnitPrice());
              }

              System.out.println("Checking if the book objects match...");
              for (int i = 0; i < expensiveBooks.size(); i++) {
                 Book bookA = expensiveBooks.get(i);
                 Book bookB = expensiveBooksByCriteriaBuilder.get(i);

                 if (!bookA.getTitle().equals(bookB.getTitle()) ||!bookA.getUnitPrice().equals(bookB.getUnitPrice())) {
                     System.out.println("Book titles or prices don't match at index " + i);
                 } else {
                  System.out.println("Book objects match at index " + i);}
             }

        }
    }
}
