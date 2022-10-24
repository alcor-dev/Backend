package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    Person person;

    @Override
    public String calculateAge() {
        return "La edad es: " + person.getAge();
    }

    @Override
    public Person createPerson(String name, String city, int age) {
        return (new Person(name, city, age));
    }
}
