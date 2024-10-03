package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            Student student = new Student("John");

            student.addCourse(new Course("Spring Boot"));
            student.addCourse(new Course("React"));
            student.addCourse(new Course("React")); // This course should be skipped as it's already in the student's courses list.
            student.addCourse(new Course("Java Fundamentals"));

            entityManager.persist(student);
            // Instead of persisting all courses, we can use CascadeType.PERSIST
            //student.getCourses().stream().forEach(entityManager::persist);

            entityManager.getTransaction().commit();

            Student fetchedStudent = entityManager.find(Student.class, student.getId());
            System.out.println("Student Courses: " + fetchedStudent.getCourses());


        }

    }
}
