package com.example.block7crudvalidation.student.infrastructure.controller;

import com.example.block7crudvalidation.student.infrastructure.controller.dto.FullStudentDTO;
import com.example.block7crudvalidation.student.infrastructure.controller.dto.StudentDTO;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.student.application.StudentService;
import com.example.block7crudvalidation.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Permite la creación de varias anotaciones sin necesidad de las anotaciones, como con Autowired
//@RequiredArgsConstructor
@RequestMapping("/student")
public class ControllerStudent {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) throws Exception {
        studentService.createStudent(student);
        Student studentData = student;
        return "Añadido estudiante: " + studentData.getId_student();
    }

    @GetMapping("/{id}")
    public StudentDTO readStudentById(@PathVariable("id") String id, @RequestParam(name = "outputType", defaultValue = "simple") String type) throws EntityNotFoundException {
        Student student = (Student) studentService.readStudentById(id);

        if (type.equals("full")) {
            FullStudentDTO fullStudentDTO = new FullStudentDTO();
            fullStudentDTO.getFullStudentInfo(student);
            return fullStudentDTO;
        } else {
            StudentDTO simpleStudentDTO = new StudentDTO();
            simpleStudentDTO.getStudentSimpleInfo(student);
            return simpleStudentDTO;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable("id") String id) throws EntityNotFoundException{
        studentService.deleteStudent(id);
        return "El alumno de ID: " + id + " ha sido eliminado";
    }

    @GetMapping("/all")
    public List<Student> readAllStudents() {
        return studentService.readEveryStudent();
    }
}
