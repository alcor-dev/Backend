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
        return "Añadido estudiante: " /*+ student.getId_student()*/;
    }

    @GetMapping("/{id}")
    public Student readStudentById(@PathVariable("id") String id, @RequestParam(name = "outputType", defaultValue = "simple") String type) throws EntityNotFoundException{
        if (type.contentEquals("full")) {
            return null;

        } else if (type.contentEquals("simple")) {

        }

        return null;
    }

//    @GetMapping("/all")
//    public List<Student> readAllStudents() throws EntityNotFoundException{
//        return studentService.readEveryStudent();
//    }
}
