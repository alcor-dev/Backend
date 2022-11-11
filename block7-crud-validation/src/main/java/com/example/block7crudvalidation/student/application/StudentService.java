package com.example.block7crudvalidation.student.application;

import com.example.block7crudvalidation.person.infrastructure.controller.dto.StudentPersonDTO;
import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;

import java.util.List;

public interface StudentService {

    String createStudent(Student student);
    String modifyStudent(Student student) throws EntityNotFoundException;
    Object readStudentById(int id) throws EntityNotFoundException;
    void deleteStudent(int id) throws EntityNotFoundException;
    List<Student> readEveryStudent();
    Boolean filterByID(List<Student> list, int id);
    Student getById(List<Student> list, int id);
}
