package com.example.block7crudvalidation.person.application;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.person.domain.Person;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface PersonService {

    String createPerson(Person person);
    Person readPersonById(int id) throws EntityNotFoundException;
    Person readPersonByName(String name) throws EntityNotFoundException;
    Person readPersonByUsername(String username) throws UsernameNotFoundException;
    String updatePerson(Person person);
    void deletePerson(int id);
    List<Person> readEveryPerson();



}
