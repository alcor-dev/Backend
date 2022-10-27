package com.example.block7crudvalidation;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {

    List<Person> readPersonByName(String name);
}
