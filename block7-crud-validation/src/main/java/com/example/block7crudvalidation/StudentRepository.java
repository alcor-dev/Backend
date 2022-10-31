package com.example.block7crudvalidation;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, String> {
    List<Student> readPersonByName(String name);
}
