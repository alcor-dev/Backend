package com.example.block10dockerizeapp.person.infrastructure.controller;

import com.example.block10dockerizeapp.person.application.PersonService;
import com.example.block10dockerizeapp.person.domain.Person;
import com.example.block10dockerizeapp.person.infrastructure.controller.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping
public class ControllerPerson {

    @Autowired
    PersonService personService;

    @PostMapping("/person/add")
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
        System.out.println("Creada persona: " + person.toString());
    }

    @GetMapping("/person/{id}")
    public PersonDTO readPersonById(@PathVariable("id") String id) throws Exception {
         return personService.readPersonById(id);
    }

    @PutMapping("/person/update")
    public void updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }

    @DeleteMapping("/person/{id}")
    public void deletePersonById(@PathVariable("id") String id) throws Exception {
        personService.deletePerson(id);
    }

}