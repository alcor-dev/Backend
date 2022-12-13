package com.example.block16springcloud.trip.domain;

import com.example.block16springcloud.passenger.domain.Passenger;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTrip;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private Date departureDate;

    @Column
    private Date arrivalDate;

    @OneToMany
    @JsonBackReference
    @JoinColumn
    private List<Passenger> passenger;

    @Column
    private String status;
}
