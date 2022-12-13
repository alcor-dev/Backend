package com.example.block16springcloud.trip.application;

import com.example.block16springcloud.trip.domain.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TripService {

    void createTrip(Trip trip);
    Trip readTrip(Integer idTrip);
    List<Trip> readAllTrips();
    void updateTrip(Trip trip);
    void deleteTrip(Integer idTrip);

}
