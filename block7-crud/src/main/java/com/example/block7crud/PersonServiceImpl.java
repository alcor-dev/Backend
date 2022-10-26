package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

//Implementamos el servicio para luego poder inyectarlo en los controladores correspondientes con Autowired
@Service
public class PersonServiceImpl implements PersonService {

    //Creamos una instancia de PersonRepository para poder utilizar los métodos obtenidos por herencia
    @Autowired
    PersonRepository personRepository;

    //Método para guardar personas
    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    //Método para actualizar personas
    @Override
    public Person updatePerson(Person person) {
        personRepository.save(person);
        return person;
    }

    //Método para lectura de personas con excepción en caso de que no se encuentre el archivo/persona por ID
    @Override
    public Person readPersonById(String id) throws FileNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new FileNotFoundException("Persona no encontrada"));
    }

    //Método para borrar personas mediante ID
    @Override
    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }
}
