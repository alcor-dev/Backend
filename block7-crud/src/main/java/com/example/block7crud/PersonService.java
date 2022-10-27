package com.example.block7crud;

import java.io.FileNotFoundException;

//Declaración de los métodos que usaremos al implementar la interfaz
public interface PersonService {

    void createPerson(Person person);
    Person updatePerson(Person person);
    Person readPersonById(String id) throws FileNotFoundException;

    Person readPersonByName(String name) throws Exception;

    void deletePerson(String id);
}
