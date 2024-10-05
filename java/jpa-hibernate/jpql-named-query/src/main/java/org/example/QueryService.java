package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QueryService {

    private final EntityManager entityManager;

    public QueryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Long countBooksByAuthorName(String firstName, String lastName) {
        // using createNamedQuery function
        TypedQuery<Long> typedQuery = entityManager.createNamedQuery(Book.COUNT_BOOKS_BY_AUTHOR_NAME, Long.class);
        typedQuery.setParameter(1, firstName);
        typedQuery.setParameter(2, lastName);

        return typedQuery.getSingleResult();
    }

    public Long countBooksByGenre(Genre genre) {
        Query query = entityManager.createNamedQuery(Book.COUNT_BOOKS_BY_GENRE, Long.class);
        query.setParameter("genre", genre);
        return (Long) query.getSingleResult();
    }

    public List<Book> getBooksBetweenPublicationYears(int fromYear, int toYear) {
        TypedQuery<Book> typedQuery = entityManager.createNamedQuery(Book.BOOKS_BETWEEN_PUBLICATION_YEARS, Book.class);
        typedQuery.setParameter("fromYear", fromYear);
        typedQuery.setParameter("toYear", toYear);
        return typedQuery.getResultList();
    }

    public List<Book> getExpensiveBooks(int limit, LocalDate localDate) {
        // for dynamic query we can use CriteriaBuilder ...
        TypedQuery<Book> typedQuery = entityManager.createNamedQuery(Book.EXPENSIVE_BOOKS, Book.class);

        typedQuery.setParameter("limit", limit);
        typedQuery.setParameter("localDate", localDate);

        return typedQuery.getResultList();
    }

    public List<Book> getExpensiveBooksByCriteriaBuilder(int limit, LocalDate localDate) {
        // Create a CriteriaBuilder and a CriteriaQuery
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);

        // average price of all books
        Subquery<Double> sub = cq.subquery(Double.class);
        Root<Book> subRoot = sub.from(Book.class);
        sub.select(cb.avg(subRoot.get("unitPrice")));

        // Create the main query
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.greaterThan(root.get("unitPrice"), sub));

        // Add optional date filter
        if (localDate!= null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("publishDate").as(LocalDate.class), localDate));
        }
        cq.where(cb.and(predicates.toArray(new Predicate[]{})));

        cq.orderBy(cb.desc(root.get("unitPrice").as(Double.class)));

        List<Book> books = entityManager.createQuery(cq).setMaxResults(limit).getResultList();
        return books;
    }
}
