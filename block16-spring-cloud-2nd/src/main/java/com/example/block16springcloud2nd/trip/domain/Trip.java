package com.example.block16springcloud2nd.trip.domain;

import com.example.block16springcloud2nd.passenger.domain.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Trip implements Serializable {

    private Integer idTrip;

    private String origin;

    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    private List<Passenger> passenger;

    private String status;

}
