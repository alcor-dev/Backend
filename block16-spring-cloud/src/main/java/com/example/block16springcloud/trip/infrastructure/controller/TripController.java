package com.example.block16springcloud.trip.infrastructure.controller;

import com.example.block16springcloud.passenger.domain.Passenger;
import com.example.block16springcloud.passenger.infrastructure.repository.PassengerRepository;
import com.example.block16springcloud.trip.application.TripServiceImpl;
import com.example.block16springcloud.trip.domain.Trip;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    TripServiceImpl tripService;

    @Autowired
    PassengerRepository passengerRepository;

    @PostMapping
    public String createTrip(@RequestBody Trip trip) {
        tripService.createTrip(trip);
        return null;
    }

    @PutMapping("/addPassenger/{id1}/{id2}")
    public String addPassengerToTrip(@PathVariable("id1") Integer idPassenger, @PathVariable("id2") Integer idTrip) {

        //Here we retrieve the trip and check if the amount of people is right for our purposes
        Trip trip = tripService.readTrip(idTrip);
        System.out.println("Hay " + trip.getPassenger().size() + " personas en el autobús");
        if (trip.getPassenger().size() >= 40) {
            System.out.println("No se admiten más personas");
            return "No se admiten más personas";
        }

        //If everything is alright then we proceed into adding the passenger we've chosen into the passenger list with
        //an update. It allows us to do clean insertions without much of a problem.
        Passenger passenger = passengerRepository.findById(idPassenger).orElseThrow(()-> new EntityNotFoundException());
        List<Passenger> listPassenger = trip.getPassenger();
        listPassenger.add(passenger);
        trip.setPassenger(listPassenger);
        tripService.updateTrip(trip);

        return "Añadido pasajero ID " + idPassenger + " a viaje ID " + idTrip;
    }


    @GetMapping("/{id}")
    public Trip readTrip(@PathVariable("id") Integer idTrip) {
        return tripService.readTrip(idTrip);
    }

    @GetMapping("/verify/{id}")
    public String verifyTrip(@PathVariable("id") Integer idTrip) {
        return "El estado del autobus de ID " + idTrip + " es actualmente: " + tripService.verify(idTrip);
    }

    @GetMapping
    public List<Trip> readAllTrips() {
        return tripService.readAllTrips();
    }

    @PutMapping
    public void updateTrip(Trip trip) {
        tripService.updateTrip(trip);
    }

    @PutMapping("/{id}/{status}")
    public String updateState(@PathVariable("id") Integer idTrip, @PathVariable("status") String status) {
        tripService.updateStatusTrip(idTrip, status);
        return "El status del autobús ha sido cambiado a: " + status;
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable("id") Integer idTrip) {
        tripService.deleteTrip(idTrip);
    }

}
