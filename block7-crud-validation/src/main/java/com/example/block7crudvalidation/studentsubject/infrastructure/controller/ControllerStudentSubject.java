package com.example.block7crudvalidation.studentsubject.infrastructure.controller;

import com.example.block7crudvalidation.studentsubject.application.StudentSubjectServiceImpl;
import com.example.block7crudvalidation.studentsubject.domain.StudentSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class ControllerStudentSubject {

    @Autowired
    StudentSubjectServiceImpl studentSubjectService;

    @GetMapping("/id/{id}")
    public StudentSubject readSubject(@PathVariable("id") String id) throws Exception{
        return studentSubjectService.readSubjects(id);
    }

    @PostMapping("/add")
    public String createSubject(@RequestBody StudentSubject studentSubject) {
        studentSubjectService.createSubjects(studentSubject);
        return "La asignatura" + studentSubject.getSubject() + " ha sido añadida";
    }

    @PutMapping("/modify")
    public String modifySubject(@RequestBody StudentSubject studentSubject) {
        studentSubjectService.modifySubjects(studentSubject);
        return "La asignatura " + studentSubject.getSubject().toUpperCase() + " ha sido actualizada";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSubject(@PathVariable("id") String id) {
        studentSubjectService.deleteSubjects(id);
        return "La asignatura de ID: " + id + " ha sido eliminada";
    }
}
