package com.example.block7crudvalidation.student.application;

import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;

public interface StudentService {

    String createStudent(Student student);
    String modifyStudent(Student student) throws EntityNotFoundException;
    Object readStudentById(String id) throws EntityNotFoundException;
    void deleteStudent(String id) throws EntityNotFoundException;
//    List<Student> readEveryStudent();
}
