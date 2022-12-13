package com.example.block16springcloud.trip.application;

import com.example.block16springcloud.trip.domain.Trip;
import com.example.block16springcloud.trip.infrastructure.repository.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    TripRepository tripRepository;

    @Override
    public void createTrip(Trip trip) {
        tripRepository.save(trip);
    }

    @Override
    public Trip readTrip(Integer idTrip) {
        return tripRepository.findById(idTrip).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Integer readTripCount(Integer idTrip) {
        Trip trip = tripRepository.findById(idTrip).orElseThrow(()-> new EntityNotFoundException());
        return trip.getPassenger().size();
    }

    @Override
    public List<Trip> readAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public String verify(Integer idTrip) {
        Trip trip = tripRepository.findById(idTrip).orElseThrow(() -> new EntityNotFoundException());
        return trip.getStatus();
    }

    @Override
    public void updateTrip(Trip trip) {
        tripRepository.save(trip);
    }

    @Override
    public void updateStatusTrip(Integer idTrip, String status) {
        Trip trip = tripRepository.findById(idTrip).orElseThrow(()-> new EntityNotFoundException());
        trip.setStatus(status);
        tripRepository.save(trip);
    }


    @Override
    public void deleteTrip(Integer idTrip) {
        tripRepository.deleteById(idTrip);
    }
}
