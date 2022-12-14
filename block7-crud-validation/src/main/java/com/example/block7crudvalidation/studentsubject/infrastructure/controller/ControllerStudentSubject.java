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
    public StudentSubject readSubject(@PathVariable("id") int id) throws Exception{
        return studentSubjectService.readSubjects(id);
    }

    @PostMapping("/add")
    public String createSubject(@RequestBody StudentSubject studentSubject) {
        studentSubjectService.createSubjects(studentSubject);
        return "La asignatura " + studentSubject.getSubject() + " ha sido añadida";
    }

    @PostMapping("/list")
    public String createSubjectList(@RequestBody List<StudentSubject> subjectList) throws Exception {
        subjectList.stream().forEach(studentSubject -> studentSubjectService.createSubjects(studentSubject));
        return "Añadiendo: " + subjectList.size() + " asignaturas";
    }

    @DeleteMapping("/list")
    public void deleteSubjectList(@RequestBody List<StudentSubject> subjectList) {
        System.out.println("Eliminando: " + subjectList.size() + " asignaturas");
        //Editar para borrar usando la ID (Pulir)
        subjectList.stream().forEach(subject -> studentSubjectService.deleteSubjects(subject.getId_subject()));
    }

    @PutMapping("/modify")
    public String modifySubject(@RequestBody StudentSubject studentSubject) {
        studentSubjectService.modifySubjects(studentSubject);
        return "La asignatura " + studentSubject.getSubject().toUpperCase() + " ha sido actualizada";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSubject(@PathVariable("id") int id) {
        studentSubjectService.deleteSubjects(id);
        return "La asignatura de ID: " + id + " ha sido eliminada";
    }

    @GetMapping("/student/{id}")
    public List<StudentSubject> readByStudentId(@PathVariable("id") int studentId) throws Exception {
        List<StudentSubject> subjectsResult = new ArrayList<>();
        List<StudentSubject> listSubjects;

        Student student = studentService.readStudentById(studentId);
        listSubjects = studentSubjectService.readEverySubject();
        listSubjects.stream().filter(SubjectStudent -> SubjectStudent.getStudent().getId_student() == studentId).forEach(subject -> subjectsResult.add(subject));
        return subjectsResult;
    }

    @GetMapping("/all")
    public List<StudentSubject> readAllSubjects() {
        List<StudentSubject> listAllSubjects = new ArrayList<>();
        listAllSubjects = studentSubjectService.readEverySubject();
        return listAllSubjects;
    }
}