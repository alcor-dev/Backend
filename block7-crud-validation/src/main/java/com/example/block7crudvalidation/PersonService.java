package com.example.block7crudvalidation;

import java.io.FileNotFoundException;
import java.util.List;

public interface PersonService {

    String createPerson(Person person);
    Person readPersonById(String id) throws FileNotFoundException;
    Person readPersonByName(String name) throws Exception;
    List<Person> readEveryPerson();
}
