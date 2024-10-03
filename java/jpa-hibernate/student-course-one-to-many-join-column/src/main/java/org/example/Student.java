package org.example;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id"
    )
    private Set<Course> courses = new HashSet<>();

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses)  ;
    }

}
