package com.example.block16springcloud.trip.application;

import com.example.block16springcloud.trip.domain.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TripService {

    void createTrip(Trip trip);
    Trip readTrip(Integer idTrip);
    Integer readTripCount(Integer idTrip);
    List<Trip> readAllTrips();
    String verify(Integer idTrip);
    void updateTrip(Trip trip);
    void updateStatusTrip(Integer idTrip, String status);
    void deleteTrip(Integer idTrip);

}
