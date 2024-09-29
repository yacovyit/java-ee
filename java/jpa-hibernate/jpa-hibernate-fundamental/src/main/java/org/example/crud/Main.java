package org.example.crud;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            BookRepository bookRepository = new BookRepository(entityManager);

            // Here is our code ....
            System.out.println("In our transaction ...");

            // persist new books
            bookRepository.persist(new Book(1L, "1984", "George Orwell's 1984", 328, 19.99f, "978-0415249353"));
            bookRepository.persist(new Book(2L, "Moby-Dick, or The Whale", "Herman Melville's 1851", 150, 12.99f, "978-04515"));

            // find books by id
            Book book1984 = bookRepository.find(1L);
            Book bookMobyDick = bookRepository.find(2L);

            System.out.println("Found book: " + book1984);
            System.out.println("Found book: " + bookMobyDick);

            // update book price
            bookMobyDick.setPrice(24.99f);
            //bookRepository.update(bookMobyDick);

            // remove book by entity or by id
            bookRepository.remove(book1984);
            bookRepository.removeById(book1984.getId());

            // find book by id again to check if it was removed
            book1984 = bookRepository.find(1L);
            System.out.println("After removal, book deleted: " + (book1984== null));
        }
    }
}