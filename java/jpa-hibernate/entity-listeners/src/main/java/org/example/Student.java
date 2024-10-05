package org.example;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;

@Entity
@Access(AccessType.FIELD)
@EntityListeners({ValidationListener.class})
public class Student extends Person {
    private String className;

    public Student(String className) {
        this.className = className;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                "} " + super.toString();
    }
}
