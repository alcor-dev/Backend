package com.example.block7crudvalidation.person.infrastructure.repository;

import com.example.block7crudvalidation.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> readPersonByName(String name);
    Person readPersonByUsername(String username);
}
