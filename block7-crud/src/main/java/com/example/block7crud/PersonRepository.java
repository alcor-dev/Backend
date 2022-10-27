package com.example.block7crud;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Creamos una interfaz repositorio para poder usar los CRUD de CRUDRepository
public interface PersonRepository extends CrudRepository<Person, String> {

    List<Person> readPersonByName(String name);
}
