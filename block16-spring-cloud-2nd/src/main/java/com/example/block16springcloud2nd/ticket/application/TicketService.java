package com.example.block16springcloud2nd.ticket.application;

import com.example.block16springcloud2nd.passenger.domain.Passenger;
import com.example.block16springcloud2nd.ticket.domain.Ticket;
import com.example.block16springcloud2nd.trip.domain.Trip;

import java.util.List;

public interface TicketService {

    void createTicket(Passenger passenger, Trip trip);
    Ticket readTicket(Integer idTicket);
    List<Ticket> readAllTickets();
    void updateTicket(Ticket ticket);
    void deleteTicket(Integer idTicket);
}
