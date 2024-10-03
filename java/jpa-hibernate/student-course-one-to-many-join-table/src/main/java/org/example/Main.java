package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            Student student = new Student("John");

            student.addCourse(new Course("Spring Boot"));
            student.addCourse(new Course("React"));
            student.addCourse(new Course("Java Fundamentals"));

            entityManager.persist(student);
            student.getCourses().stream().forEach(entityManager::persist);

            entityManager.getTransaction().commit();
        }

    }
}
