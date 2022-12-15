package com.example.block16springcloud2nd.ticket.infrastructure.controller;

import com.example.block16springcloud2nd.feign.FeignServer;
import com.example.block16springcloud2nd.passenger.domain.Passenger;
import com.example.block16springcloud2nd.ticket.application.TicketServiceImpl;
import com.example.block16springcloud2nd.ticket.domain.Ticket;
import com.example.block16springcloud2nd.trip.domain.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generateTicket")
public class TicketController {

    @Autowired
    FeignServer feignServer;

    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping("/{idPassenger}/{idTrip}")
    public String createTicket(@PathVariable("idPassenger") Integer idPassenger, @PathVariable("idTrip") Integer idTrip) {

        Passenger passenger = feignServer.readPassengerById(idPassenger);
        Trip trip = feignServer.readTripById(idTrip);

        ticketService.createTicket(passenger, trip);
        return "El ticket de " + passenger.getFirstName() + " y viaje a " + trip.getDestination() + " ha sido creado";
    }

    @GetMapping("/feign/{idPassenger}")
    public Passenger readFeign(@PathVariable("idPassenger") Integer idPassenger) {
        return feignServer.readPassengerById(idPassenger);
    }

    @GetMapping("/{id}")
    public Ticket readTicket(@PathVariable("id") Integer idTicket) {
        return ticketService.readTicket(idTicket);
    }

    @GetMapping
    public List<Ticket> readAllTickets() {
        return ticketService.readAllTickets();
    }

    @PutMapping()
    public void updateTicket(Ticket ticket) {
        ticketService.updateTicket(ticket);
    }
}
