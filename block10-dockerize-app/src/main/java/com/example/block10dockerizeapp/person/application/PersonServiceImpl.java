package com.example.block10dockerizeapp.person.application;

import com.example.block10dockerizeapp.person.domain.Person;
import com.example.block10dockerizeapp.person.infrastructure.controller.dto.PersonDTO;
import com.example.block10dockerizeapp.person.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
        System.out.println("Creada la persona: " + person.toString());
    }

    @Override
    public PersonDTO readPersonById(String id) throws Exception {
        //Keeping controllers cleaner by doing all the operations within the Service methods
        PersonDTO personDTO = new PersonDTO();
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        personDTO.transferPersonToDto(person);
        return personDTO;
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
        System.out.println("Actualizada persona con ID: " + person.getIdPerson());
    }

    @Override
    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }
}
