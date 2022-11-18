package com.example.block10dockerizeapp.person.application;


import com.example.block10dockerizeapp.person.domain.Person;
import com.example.block10dockerizeapp.person.infrastructure.controller.dto.PersonDTO;

public interface PersonService {

    void createPerson(Person person);
    PersonDTO readPersonById(Integer id) throws Exception;
    void updatePerson(Person person);
    void deletePerson(Integer id);
}
