package com.example.block7crudvalidation.person.infrastructure.repository;

import com.example.block7crudvalidation.person.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {

    List<Person> readPersonByName(String name);
}
