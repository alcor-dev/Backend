package com.example.block7crudvalidation.student.application;

import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.student.infrastructure.repository.StudentRepository;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

//    final List<Student> allStudent = new ArrayList<>();

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String createStudent(Student student) {
        studentRepository.save(student);
        return "Creado el estudiante:" +  student.getId_student();
    }

    @Override
    public String modifyStudent(Student student) {
        studentRepository.save(student);
        return "Modificado el estudiante";
    }

    @Override
    public Student readStudentById(String id) throws EntityNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
