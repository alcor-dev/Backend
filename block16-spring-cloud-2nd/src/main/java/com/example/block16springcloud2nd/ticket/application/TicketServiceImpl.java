package com.example.block16springcloud2nd.ticket.application;

import com.example.block16springcloud2nd.passenger.domain.Passenger;
import com.example.block16springcloud2nd.ticket.domain.Ticket;
import com.example.block16springcloud2nd.ticket.infrastructure.repository.TicketRepository;
import com.example.block16springcloud2nd.trip.domain.Trip;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void createTicket(Passenger passenger, Trip trip) {
        ticketRepository.save(new Ticket(passenger, trip)) ;
    }

    @Override
    public Ticket readTicket(Integer idTicket) {
        return ticketRepository.findById(idTicket).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public List<Ticket> readAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Integer idTicket) {

    }
}
