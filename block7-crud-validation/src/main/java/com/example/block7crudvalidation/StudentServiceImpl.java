package com.example.block7crudvalidation;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService{

    final List<Student> allStudent = new ArrayList<>();

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
    public Student readStudentById(String id) throws EntityNotFoundException{
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Student readStudentByName(String name) throws EntityNotFoundException {
        List<Student> foundName = new ArrayList<>();
        studentRepository.readPersonByName(name).forEach(student -> {
            foundName.add(student);
        });

        Student student = foundName.get(0);
        return student;
    }

    @Override
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Eliminado el estudiante de id: " + id;
    }

    @Override
    public List<Student> readEveryStudent() {
        studentRepository.findAll().forEach(person -> allStudent.add(person));
        return allStudent;
    }
}
