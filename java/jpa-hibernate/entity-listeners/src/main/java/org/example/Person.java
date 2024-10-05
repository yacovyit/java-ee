package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@MappedSuperclass
@Access(AccessType.PROPERTY)
@EntityListeners({AgeCalculationListener.class})
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDateTime;
    private Integer age;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column(name = "first_name", length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "birth_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime getBirthDateTime() {
        return birthDateTime;
    }

    public void setBirthDateTime(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }


}
