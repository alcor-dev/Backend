package com.example.block7crudvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    final List<Student> allStudent = new ArrayList<>();

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;

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
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Eliminado el estudiante de id: " + id;
    }

//    @Override
//    public List<Student> readEveryStudent() {
//        studentRepository.readAllStudents().forEach(student -> allStudent.add(student));
//        return allStudent;
//    }
}
