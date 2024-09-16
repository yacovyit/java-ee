package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-book");

        BookRepositroy bookRepositroy = new BookRepositroy(entityManagerFactory);

        Books book = new Books();
        book.setTitle("Harry Potter");
        book.setNumOfPages(650);

        bookRepositroy.addBook(book);
        Books bookFromDB = bookRepositroy.getBook(book.getId());
        System.out.println(bookFromDB);

        bookRepositroy.removeBook(book.getId());
        // try with resources
//        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
//            // start transaction
//            entityManager.getTransaction().begin();
//
//            // end transaction
//            entityManager.getTransaction().commit();
//        }




    }
}