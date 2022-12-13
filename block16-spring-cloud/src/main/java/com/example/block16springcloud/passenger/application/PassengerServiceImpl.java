package com.example.block16springcloud.passenger.application;


import com.example.block16springcloud.passenger.domain.Passenger;
import com.example.block16springcloud.passenger.infrastructure.controller.dto.PassengerInputDTO;
import com.example.block16springcloud.passenger.infrastructure.controller.dto.PassengerOutputDTO;
import com.example.block16springcloud.passenger.infrastructure.repository.PassengerRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public void createPassenger(PassengerInputDTO passengersInputDTO) {
        passengerRepository.save(new Passenger(passengersInputDTO));
    }

    @Override
    public PassengerOutputDTO readPassenger(Integer idClients) {
        Passenger passenger = passengerRepository.findById(idClients).orElseThrow(() -> new EntityNotFoundException());
        return new PassengerOutputDTO(passenger);
    }

    @Override
    public Passenger getPassenger(Integer idClients) {
        return passengerRepository.findById(idClients).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public List<PassengerOutputDTO> readAllPassengers() {
        List<Passenger> listClients = passengerRepository.findAll();
        List<PassengerOutputDTO> listOutput = new ArrayList<>();
        listClients.stream().forEach(passenger -> listOutput.add(new PassengerOutputDTO(passenger)));
        return listOutput;
    }

    @Override
    public void updatePassenger(PassengerInputDTO clientsInputDTO) {
        passengerRepository.save(new Passenger(clientsInputDTO));
    }

    @Override
    public void deletePassenger(Integer idClients) {
        passengerRepository.deleteById(idClients);
    }
}
