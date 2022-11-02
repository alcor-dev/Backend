package com.example.block7crudvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public Student readStudentById(@PathVariable("id") String id, @RequestParam(name = "outputType", defaultValue = "simple") String type) throws EntityNotFoundException{
        if (type.contentEquals("full")) {
            Student student = (Student) studentService.readStudentById(id);
            FullStudentDTO fullStudentDTO = new FullStudentDTO().getFullStudentInfo(student);
            return fullStudentDTO;

        } else if (type.contentEquals("simple")) {
            Student student = (Student) studentService.readStudentById(id);
            SimpleStudentDTO simpleStudentDTO = new SimpleStudentDTO().getStudentSimpleInfo(student);
            return simpleStudentDTO;
        } else {
            return null;
        }
    }

//    @GetMapping("/all")
//    public List<Student> readAllStudents() throws EntityNotFoundException{
//        return studentService.readEveryStudent();
//    }
}
