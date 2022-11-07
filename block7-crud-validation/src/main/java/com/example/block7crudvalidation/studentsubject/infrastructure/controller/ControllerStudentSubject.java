package com.example.block7crudvalidation.studentsubject.infrastructure.controller;

import com.example.block7crudvalidation.student.application.StudentServiceImpl;
import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.studentsubject.application.StudentSubjectServiceImpl;
import com.example.block7crudvalidation.studentsubject.domain.StudentSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class ControllerStudentSubject {

    @Autowired
    StudentSubjectServiceImpl studentSubjectService;

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/id/{id}")
    public StudentSubject readSubject(@PathVariable("id") String id) throws Exception{
        return studentSubjectService.readSubjects(id);
    }

    @PostMapping("/add")
    public String createSubject(@RequestBody StudentSubject studentSubject) {
        studentSubjectService.createSubjects(studentSubject);
        return "La asignatura " + studentSubject.getSubject() + " ha sido añadida";
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

    @GetMapping("/student/{id}")
    public List<StudentSubject> readByStudentId(@PathVariable("id") String studentId) throws Exception {
        List<StudentSubject> subjectsResult = new ArrayList<>();
        List<StudentSubject> listSubjects;

        Student student = studentService.readStudentById(studentId);
        listSubjects = studentSubjectService.readEverySubject();
        listSubjects.stream().filter(SubjectStudent -> SubjectStudent.getStudent().getId_student() == Integer.parseInt(studentId)).forEach(subject -> subjectsResult.add(subject));
        return subjectsResult;
    }

    @GetMapping("/all")
    public List<StudentSubject> readAllSubjects() {
        List<StudentSubject> listAllSubjects = new ArrayList<>();
        listAllSubjects = studentSubjectService.readEverySubject();
        return listAllSubjects;
    }
}
