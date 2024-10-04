package org.example.student;

import jakarta.persistence.EntityManager;

public class StudentRepository {

    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public long countStudentsUsingJPQL() {
        String query = "SELECT COUNT(s) FROM Student s";
        long count = entityManager.createQuery(query, Long.class).getSingleResult();

        return count;
    }
}
