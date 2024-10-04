package org.example.student;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Student {

    @EmbeddedId
    private StudentEmbeddableId id;

    private String className;

    public Student(StudentEmbeddableId id, String className) {
        this.id = id;
        this.className = className;
    }

    public Student() {
    }

    public StudentEmbeddableId getId() {
        return id;
    }

    public void setId(StudentEmbeddableId id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


}
