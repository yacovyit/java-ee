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

//            Student anonimusStudent = new Student();
//
//            anonimusStudent.setFirstName("Anonimus");
//            anonimusStudent.setLastName("Student");
//            entityManager.persist(anonimusStudent);

            // Create a new book
            Student student = new Student();
            student.setFirstName("Michael");
            student.setLastName("Jordan");
            student.setBirthDateTime(java.time.LocalDateTime.of(1963, 2, 17, 1, 12, 1));

            // Save the book
            entityManager.persist(student);

            // Commit the transaction
            entityManager.getTransaction().commit();

            System.out.println(student);
            //System.out.println(anonimusStudent);



        }
    }
}
