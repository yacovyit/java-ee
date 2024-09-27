package org.example.flight;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {

    @Id
    private Long id;

    private String firstName;
    private String lastName;

    public Passenger() {
    }

    public Passenger(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets =  new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }


}
