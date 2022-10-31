package com.example.block7crudvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class ControllerStudent {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) throws Exception {
        studentService.createStudent(student);
        return "Añadido estudiante: " + student.getId_student();
    }

    @GetMapping("/{id}")
    public Object readStudentById(@PathVariable("id") String id, @RequestParam("outputType") String type) throws EntityNotFoundException{
        if (type.contentEquals("full")) {


        }
        return studentService.readStudentById(id);
    }

    @GetMapping("/{name}")
    public Student readStudentByName(@PathVariable("name") String name) throws EntityNotFoundException{
        return studentService.readStudentByName(name);
    }
}
