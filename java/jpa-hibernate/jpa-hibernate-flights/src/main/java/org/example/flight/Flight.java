package org.example.flight;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "FLIGHTS")
@Access(AccessType.FIELD)
public class Flight {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "FLIGHT_NUMBER")
    private String flightNumber;

    @OneToMany(mappedBy = "flight")
    private List<Passenger> passengers = new ArrayList<>();

    public Flight() {
    }

    public Flight(Long id, String flightNumber) {
        this.id = id;
        this.flightNumber = flightNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Passenger> getPassenger() {
        return Collections.unmodifiableList(passengers);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}
