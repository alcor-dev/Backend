package com.example.block16springcloud.trip.infrastructure.repository;

import com.example.block16springcloud.trip.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
