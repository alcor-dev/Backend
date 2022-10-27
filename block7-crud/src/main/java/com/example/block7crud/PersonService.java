package com.example.block7crud;

import java.io.FileNotFoundException;

//Declaración de los métodos que usaremos al implementar la interfaz
public interface PersonService {

    //Método para creación de persona
    void createPerson(Person person);
    //Método para Actualización de persona
    Person updatePerson(Person person);
    //Método para lectura de persona por ID
    Person readPersonById(String id) throws FileNotFoundException;
    //Método para lectura de persona por nombre
    Person readPersonByName(String name) throws Exception;
    //Método para borrado de persona
    void deletePerson(String id);
}
