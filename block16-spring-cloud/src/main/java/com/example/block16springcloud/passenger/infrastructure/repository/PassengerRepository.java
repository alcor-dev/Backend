package com.example.block16springcloud.passenger.infrastructure.repository;

import com.example.block16springcloud.passenger.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
