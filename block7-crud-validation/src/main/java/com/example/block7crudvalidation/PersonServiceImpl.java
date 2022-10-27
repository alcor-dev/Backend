package com.example.block7crudvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    final List<Person> allPerson = new ArrayList<>();

    @Override
    public String createPerson(Person person) {
        personRepository.save(person);
        return "Introducida la persona: " + person.getName();
    }

    @Override
    public Person readPersonById(String id) throws FileNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new FileNotFoundException());
    }

    @Override
    public Person readPersonByName(String name) throws Exception {
        List<Person> foundName = new ArrayList<>();
        personRepository.readPersonByName(name).forEach(person -> {
            foundName.add(person);
        });

        Person person = foundName.get(0);
        return person;
    }

    @Override
    public List<Person> readEveryPerson() {

       personRepository.findAll().forEach(person -> allPerson.add(person));
       return allPerson;
    }
}
