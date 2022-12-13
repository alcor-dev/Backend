package com.example.block16springcloud.clients.infrastructure.repository;

import com.example.block16springcloud.clients.domain.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {
}
