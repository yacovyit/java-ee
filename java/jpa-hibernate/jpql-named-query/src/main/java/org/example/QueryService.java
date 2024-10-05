package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class QueryService {

    private final EntityManager entityManager;

    public QueryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Long countBooksByAuthorName(String firstName, String lastName) {
        // position parameters start from 1
        String queryString = "SELECT count(b) from Author a JOIN a.books b WHERE a.firstName = ?1 AND a.lastName = ?2";
        TypedQuery<Long> typedQuery = entityManager.createQuery(queryString, Long.class);
        typedQuery.setParameter(1, firstName);
        typedQuery.setParameter(2, lastName);

        return typedQuery.getSingleResult();
    }

    public Long countBooksByGenre(Genre genre) {
        // using named parameter (to avoid SQL injection)
        String queryString = "SELECT COUNT(b) FROM Book b WHERE b.genre = :genre";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("genre", genre);
        return (Long) query.getSingleResult();
    }

    public List<Book> getBooksBetweenPublicationYears(int fromYear, int toYear) {
        String queryString = "SELECT b FROM Book b WHERE YEAR(b.publishDate) BETWEEN :fromYear AND :toYear ORDER BY b.publishDate ASC";
        TypedQuery<Book> typedQuery = entityManager.createQuery(queryString, Book.class);
        typedQuery.setParameter("fromYear", fromYear);
        typedQuery.setParameter("toYear", toYear);
        return typedQuery.getResultList();
    }

    public List<Book> getExpensiveBooks(int limit, LocalDate localDate) {
        BigDecimal avgPrice = entityManager.createQuery("SELECT CAST(AVG(b.unitPrice) AS BIGDECIMAL(10,2)) FROM Book b", BigDecimal.class).getSingleResult();
        System.out.println("Average book price: " + avgPrice);

        //String queryString = "SELECT b FROM Book b WHERE b.unitPrice > :avgPrice  ORDER BY b.unitPrice DESC LIMIT :limit";\
        String queryString = "SELECT b FROM Book b WHERE b.unitPrice > :avgPrice";
        if (localDate!= null) {
            queryString += " AND b.publishDate >= :localDate";
        }
        queryString += " ORDER BY b.unitPrice DESC LIMIT :limit";

        TypedQuery<Book> typedQuery = entityManager.createQuery(queryString, Book.class);
        typedQuery.setParameter("avgPrice", avgPrice);
        typedQuery.setParameter("limit", limit);

        if (localDate!= null) {
            typedQuery.setParameter("localDate", localDate);
        }

        return typedQuery.getResultList();
    }

}
