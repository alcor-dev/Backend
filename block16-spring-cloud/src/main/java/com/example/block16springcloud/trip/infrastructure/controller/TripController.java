package com.example.block16springcloud.trip.infrastructure.controller;

import com.example.block16springcloud.trip.application.TripServiceImpl;
import com.example.block16springcloud.trip.domain.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    TripServiceImpl tripService;

    @PostMapping
    public String createTrip(Trip trip) {
        tripService.createTrip(trip);
        return null;
    }

    @GetMapping("/{id}")
    public Trip readTrip(@PathVariable("id") Integer idTrip) {
        return tripService.readTrip(idTrip);
    }

    @GetMapping
    public List<Trip> readAllTrips() {
        return tripService.readAllTrips();
    }

    @PutMapping
    public void updateTrip(Trip trip) {
        tripService.updateTrip(trip);
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable("id") Integer idTrip) {
        tripService.deleteTrip(idTrip);
    }

}
