package com.example.block16springcloud.passenger.application;

import com.example.block16springcloud.passenger.domain.Passenger;
import com.example.block16springcloud.passenger.infrastructure.controller.dto.PassengerInputDTO;
import com.example.block16springcloud.passenger.infrastructure.controller.dto.PassengerOutputDTO;

import java.util.List;

public interface PassengerService {

    void createPassenger(PassengerInputDTO passengerInputDTO);
    PassengerOutputDTO readPassenger(Integer idClients);
    Passenger getPassenger(Integer idClients);
    List<PassengerOutputDTO> readAllPassengers();
    void updatePassenger(PassengerInputDTO passengersInputDTO);
    void deletePassenger(Integer idClients);
}
