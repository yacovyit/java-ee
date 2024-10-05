package org.example;

import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
// To exclude default and superclass listeners and listeners defined in the superclass.
@ExcludeDefaultListeners
@ExcludeSuperclassListeners
@EntityListeners({AgeCalculationListener.class})
public class Teacher extends Person  {
    private String subject;

    public Teacher(String subject) {
        this.subject = subject;
    }

    public Teacher() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                "} " + super.toString();
    }
}
