package org.example.datatypes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactoryMSSQL = Persistence.createEntityManagerFactory("mysql");
//        EntityManager entityManager = entityManagerFactoryMSSQL.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.getTransaction().commit();
//        entityManager.close();
    }
}
