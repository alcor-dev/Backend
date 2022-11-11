package com.example.block7crudvalidation.student.application;

import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.student.infrastructure.repository.StudentRepository;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

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
    public Student readStudentById(int id) throws EntityNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> readEveryStudent() {
        List<Student> allStudent = new ArrayList<>();
        studentRepository.findAll().forEach(student -> allStudent.add(student));
        return allStudent;
    }

    //Filtro para buscar dentro de la clase Student un id_person como el requerido
    //Lo usamos a modo de condición para poder usarlo en un IF
    @Override
    public Boolean filterByID(List<Student> list, int id) {
        List<Student> studentResult = new ArrayList<>();
        list.stream().filter(Student -> Student.getPerson().getId_person() == id).forEach(student -> studentResult.add(student));
        return (studentResult.size() > 0);
    }

    //Una vez pasado el if, devolvemos el Student indicado con la ID exigida
    @Override
    public Student getById(List<Student> list, int id) {
        List<Student> studentRecover= new ArrayList<>();
        list.stream().filter(Student -> Student.getPerson().getId_person() == id).forEach(student -> studentRecover.add(student));
        return studentRecover.get(0);
    }
}