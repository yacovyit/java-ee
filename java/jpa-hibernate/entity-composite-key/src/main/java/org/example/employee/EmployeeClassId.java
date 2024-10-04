package org.example.employee;


import java.io.Serializable;
import java.util.Objects;

// Composite primary key using @IdClass annotation
public class EmployeeClassId implements Serializable {
    private String firstName;
    private String lastName;

    public EmployeeClassId() {
    }

    public EmployeeClassId(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeClassId that = (EmployeeClassId) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
