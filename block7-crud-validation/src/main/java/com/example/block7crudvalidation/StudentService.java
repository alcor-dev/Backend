package com.example.block7crudvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    String createStudent(Student student);
    String modifyStudent(Student student) throws EntityNotFoundException;
    Object readStudentById(String id) throws EntityNotFoundException;
    String deleteStudent(String id) throws EntityNotFoundException;
//    List<Student> readEveryStudent();
}
