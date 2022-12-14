package com.example.block16springcloud2nd.ticket.domain;

import com.example.block16springcloud2nd.passenger.domain.Passenger;
import com.example.block16springcloud2nd.trip.domain.Trip;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Serializable {

    public Ticket(Passenger passenger, Trip trip) {

        this.setIdPassenger(passenger.getIdPassenger());
        this.setPassengerName(passenger.getFirstName());
        this.setPassengerLastName(passenger.getLastName());
        this.setPassengerEmail(passenger.getEmail());
        this.setTripOrigin(trip.getOrigin());
        this.setTripDestination(trip.getDestination());
        this.setDepartureDate(trip.getDepartureDate());
        this.setArrivalDate(trip.getArrivalDate());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTicket;

    @Column
    private Integer idPassenger;

    @Column
    private String passengerName;

    @Column
    private String passengerLastName;

    @Column
    private String passengerEmail;

    @Column
    private String tripOrigin;

    @Column
    private String tripDestination;

    @Column
    private Date departureDate;

    @Column
    private Date arrivalDate;
}
