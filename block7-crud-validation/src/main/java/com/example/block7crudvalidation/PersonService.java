package com.example.block7crudvalidation;

import java.io.FileNotFoundException;
import java.util.List;

public interface PersonService {

    String createPerson(Person person);
    Person readPersonById(String id) throws EntityNotFoundException;
    Person readPersonByName(String name) throws EntityNotFoundException;
    String updatePerson(Person person);
    String deletePerson(String id);
    List<Person> readEveryPerson();
}
