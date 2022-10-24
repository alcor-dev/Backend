package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;

public interface PersonService {
    @Autowired
    String calculateAge();
    Person createPerson(String name, String city, int age);
}
