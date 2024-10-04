package org.example.employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EmployeeRepository {

    private final EntityManager entityManager;

    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public long countEmployeeUsingCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(criteriaBuilder.count(root));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
