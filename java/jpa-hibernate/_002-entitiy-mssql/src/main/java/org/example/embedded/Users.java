package org.example.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.example.embedded.Address;

//@Entity
public class Users {
    @Id
    private Long id;
    private String name;
    @Embedded
    private Address address;
}
