package org.example;

import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InitDB {
    private final EntityManager entityManager;

    public InitDB(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void init() {
        // Initialize database here
        entityManager.getTransaction().begin();

        Author issacAsimov = new Author("Issac", "Asimov");

        Book foundationBook = new Book("Foundation", "978-0441154860", BigDecimal.valueOf(28.22), LocalDate.of(1951,1,1), 255, Genre.SCI_FI);
        foundationBook.addAuthor(issacAsimov);

        Book iRobotBook = new Book("I, Robot", "978-0765376655", BigDecimal.valueOf(25.33), LocalDate.of(1950,11, 2), 253, Genre.SCI_FI);
        iRobotBook.addAuthor(issacAsimov);

        Book theLastQuestionBook = new Book("The Last Question", "978-0307463745", BigDecimal.valueOf(28), LocalDate.of(1956,1,1), 50, Genre.SCI_FI);
        theLastQuestionBook.addAuthor(issacAsimov);

        Author douglasAdams = new Author("Douglas", "Adams");

        Book theHitchikerBook = new Book("The Hitchhiker's Guide to the Galaxy", "978-0345391803", BigDecimal.valueOf(24), LocalDate.of(1979,1,1), 283, Genre.SCI_FI);
        theHitchikerBook.addAuthor(douglasAdams);

        Author jrrTolkien = new Author("John Ronald Reuel", "Tolkien");
        Book theLordOfTheRingsBook = new Book("The Lord of the Rings", "978-0544388781", BigDecimal.valueOf(25.44), LocalDate.of(1954,7,1), 1024, Genre.FANTASY);
        theLordOfTheRingsBook.addAuthor(jrrTolkien);

        Book theHobbitBook = new Book("The Hobbit", "978-0345396867", BigDecimal.valueOf(24.67), LocalDate.of(1937, 1, 1), 310, Genre.FANTASY);
        theHobbitBook.addAuthor(jrrTolkien);

        Author pauloCoelho = new Author("Paulo", "Coelho");
        Book theAlchemistBook = new Book("The Alchemist", "978-0804137382", BigDecimal.valueOf(24), LocalDate.of(1988, 1, 1), 182, Genre.ROMANCE);
        theAlchemistBook.addAuthor(pauloCoelho);

        Author stephenKing = new Author("Stephen", "King");
        Book itBook = new Book("It", "978-0060739351", BigDecimal.valueOf(45.33), LocalDate.of(1986, 1, 1), 181, Genre.HORROR);
        itBook.addAuthor(stephenKing);

        Book petSemataryBook = new Book("Pet Sematary", "978-0316769484", BigDecimal.valueOf(24.12), LocalDate.of(1983, 1, 1), 255, Genre.HORROR);
        petSemataryBook.addAuthor(stephenKing);


        // All books' authors
        entityManager.persist(issacAsimov);
        entityManager.persist(douglasAdams);
        entityManager.persist(jrrTolkien);
        entityManager.persist(pauloCoelho);
        entityManager.persist(stephenKing);

        // issac Asimov's books'
        entityManager.persist(foundationBook);
        entityManager.persist(iRobotBook);
        entityManager.persist(theLastQuestionBook);

        // Douglas Adams's books'
        entityManager.persist(theHitchikerBook);

        // J.R.R. Tolkien's books'
        entityManager.persist(theLordOfTheRingsBook);
        entityManager.persist(theHobbitBook);

        // Paulo Coelho's books'
        entityManager.persist(theAlchemistBook);

        // Stephen King's books'
        entityManager.persist(itBook);
        entityManager.persist(petSemataryBook);

        // commit the changes
        entityManager.getTransaction().commit();
    }
}
