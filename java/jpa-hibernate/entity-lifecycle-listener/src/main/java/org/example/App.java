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
            Teacher teacher = new Teacher("Basketball 101");
            teacher.setFirstName("Michael");
            teacher.setLastName("Jordan");
            teacher.setBirthDateTime(java.time.LocalDateTime.of(1963, 2, 17, 0, 0, 0));

            Student student = new Student("Basketball 101");
            student.setFirstName("LaBron");
            student.setLastName("James");
            student.setBirthDateTime(java.time.LocalDateTime.of(1984, 11, 30, 0, 0, 0));

            // Save teacher and student
            entityManager.persist(teacher);
            entityManager.persist(student);

            // Commit the transaction
            entityManager.getTransaction().commit();

            System.out.println("Persisted teachers and students");
            System.out.println("Teacher: " + teacher);
            System.out.println("Student: " + student);
        }

    }
}
