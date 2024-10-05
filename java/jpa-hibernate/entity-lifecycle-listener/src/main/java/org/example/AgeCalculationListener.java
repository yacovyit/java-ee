package org.example;


import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class AgeCalculationListener {

    @PostLoad
    @PostPersist
    @PostUpdate
    public void calculateAge(Person person) {
        LocalDateTime birtheDateTime = person.getBirthDateTime();
        if (birtheDateTime == null) {
            person.setAge(null);
            return;
        }
        person.setAge(Period.between(birtheDateTime.toLocalDate(), LocalDate.now()).getYears());
    }
}
