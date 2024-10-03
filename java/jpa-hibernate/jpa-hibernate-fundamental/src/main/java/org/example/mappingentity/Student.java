package org.example.mappingentity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "Students", schema = "dbo", catalog = "demo")
public class Student {
    // AUTO - hibernate decide the best strategy for primary key generation
    //@GeneratedValue(strategy = GenerationType.AUTO)

    // IDENTITY − database is responsible to auto generate the primary key
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    // SEQUENCE - get from database the next set of the sequence then insert row with return sequence id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    // TABLE - the sequence is created in the database as rows of table
    //@GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50, unique = true)
    private String firstName;

    private String lastName;

    private String address;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Transient
    private Integer age;

    private String biography;

    //@Enumerated(EnumType.ORDINAL)
    @Enumerated(EnumType.STRING)
    private Language language;

    public Student(String firstName, String lastName, String address, LocalDate birthDate, String biography, Language language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = birthDate;
        this.biography = biography;
        this.language = language;
    }

    public Student() {
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String nationality) {
        this.address = nationality;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Integer getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
