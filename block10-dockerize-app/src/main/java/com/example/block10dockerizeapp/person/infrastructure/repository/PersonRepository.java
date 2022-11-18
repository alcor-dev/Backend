package com.example.block10dockerizeapp.person.infrastructure.repository;

import com.example.block10dockerizeapp.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
