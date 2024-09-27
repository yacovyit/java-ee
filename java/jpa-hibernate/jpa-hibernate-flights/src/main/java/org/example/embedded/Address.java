package org.example.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

//@Embeddable
public class Address {
    private String street;
    private String city;
    private String country;
    private String zipCode;
}
