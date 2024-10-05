package org.example;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class ValidationListener {

    @PrePersist
    @PreUpdate
    public void validate(Person person) {
        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
    }
}
