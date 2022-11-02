package com.example.block7crudvalidation.student.infrastructure.repository;

import com.example.block7crudvalidation.student.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

//    List<Student> readAllStudents();
}
