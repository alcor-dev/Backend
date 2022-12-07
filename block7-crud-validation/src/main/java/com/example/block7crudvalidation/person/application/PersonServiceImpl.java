package com.example.block7crudvalidation.person.application;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.person.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public String createPerson(Person person) {
        personRepository.save(person);
        return "Introducida la persona: " + person.getName();
    }

    @Override
    public Person readPersonById(int id) throws EntityNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Person readPersonByName(String name) throws EntityNotFoundException {
        List<Person> foundName = new ArrayList<>();
        personRepository.readPersonByName(name).forEach(person -> {
            foundName.add(person);
        });

        Person person = foundName.get(0);
        return person;
    }

    @Override
    public Person readPersonByUsername(String username) throws UsernameNotFoundException {
        return personRepository.readPersonByUsername(username);
    }

    @Override
    public String updatePerson(Person person) {
        personRepository.save(person);
        return "La persona: " + person.getName().toUpperCase() + " ha sido actualizada";
    }



    @Override
    public void deletePerson(int id){
        personRepository.deleteById(id);
        System.out.println("La persona con ID: " + id + "ha sido eliminada");
    }

    @Override
    public List<Person> readEveryPerson() {
       List<Person> allPerson = new ArrayList<>();
       personRepository.findAll().forEach(person -> allPerson.add(person));
       return allPerson;
    }
}