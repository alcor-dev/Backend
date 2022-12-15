package com.example.block16springcloud2nd.feign;

import com.example.block16springcloud2nd.passenger.domain.Passenger;
import com.example.block16springcloud2nd.trip.domain.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ticketFeign", url = "http://localhost:8080")
public interface FeignServer {

    @GetMapping("/passenger/feign/{id}")
    Passenger readPassengerById(@PathVariable("id") Integer idPassenger);

    @GetMapping("/trip/{id}")
    Trip readTripById(@PathVariable("id") Integer idTrip);
}
