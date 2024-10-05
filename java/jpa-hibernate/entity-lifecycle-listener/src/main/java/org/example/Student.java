package org.example;

import jakarta.persistence.*;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                "} " + super.toString();
    }
}
