package com.example.block16springcloud.passenger.infrastructure.controller;

import com.example.block16springcloud.passenger.application.PassengerServiceImpl;
import com.example.block16springcloud.passenger.domain.Passenger;
import com.example.block16springcloud.passenger.infrastructure.controller.dto.PassengerInputDTO;
import com.example.block16springcloud.passenger.infrastructure.controller.dto.PassengerOutputDTO;
import com.example.block16springcloud.trip.application.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerServiceImpl passengerService;

    @Autowired
    TripServiceImpl tripService;

    @PostMapping
    public String addClients(@RequestBody PassengerInputDTO passengerInputDTO) {
        passengerService.createPassenger(passengerInputDTO);
        return "Creado el cliente: " + passengerInputDTO.getFirstName();
    }

    @GetMapping("/{id}")
    public PassengerOutputDTO readPassenger(@PathVariable("id") Integer idClient) {
        return passengerService.readPassenger(idClient);
    }

    @GetMapping("/feign/{id}")
    public Passenger readPassengerFeign(@PathVariable("id") Integer idPassenger) {
        return passengerService.getPassenger(idPassenger);
    }

    @GetMapping
    public List<PassengerOutputDTO> readAllPassengers() {
        return passengerService.readAllPassengers();
    }

    @GetMapping("/count/{id}")
    public String countPassengersTrip(@PathVariable("id") Integer idTrip) {
        return "El número de viajeros ahora mismo en el viaje de ID " + idTrip + " es de " + tripService.readTripCount(idTrip) + " personas";
    }

    @PutMapping
    public String updateClient(@RequestBody PassengerInputDTO passengerInputDTO) {
        passengerService.updatePassenger(passengerInputDTO);
        return "El cliente " + passengerInputDTO.getFirstName() + " ha sido actualizado";
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Integer idPassenger) {
        passengerService.deletePassenger(idPassenger);
        return "El cliente de ID " + idPassenger + " ha sido eliminado";
    }
}