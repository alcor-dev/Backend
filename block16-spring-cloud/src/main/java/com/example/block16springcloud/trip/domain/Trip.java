package com.example.block16springcloud.trip.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

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

    @Column
    private String passenger;

    @Column
    private String status;
}
