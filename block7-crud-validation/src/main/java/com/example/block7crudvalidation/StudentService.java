package com.example.block7crudvalidation;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StudentService {

    String createStudent(Student student);
    String modifyStudent(Student student);
    Student readStudentById(String id) throws EntityNotFoundException;
    Student readStudentByName(String name) throws EntityNotFoundException;
    String deleteStudent(String id);
    List<Student> readEveryStudent();
}
