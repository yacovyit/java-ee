package org.example.flight;

import jakarta.persistence.*;

@Entity
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER")
    private String ticketNumber;

    @ManyToOne
    @JoinColumn(name = "PASSENGER_ID")
    private Passenger passenger;

    public Ticket() {
    }

    public Ticket(Long id, String number) {
        this.id = id;
        this.ticketNumber = number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String number) {
        this.ticketNumber = number;
    }

    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
