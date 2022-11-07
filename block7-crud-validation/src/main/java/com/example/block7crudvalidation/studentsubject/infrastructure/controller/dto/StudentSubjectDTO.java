package com.example.block7crudvalidation.studentsubject.infrastructure.controller.dto;

import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.studentsubject.domain.StudentSubject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjectDTO implements Serializable {

    //Parte de Student
    private int num_hours_week;

    private String comments;

    private String branch;

    //Parte de Subject

    private int id_subject;

    private String subject;

    private Date initial_date;

    private Date finish_date;

    public void getStudentData(StudentSubject studentSubject) {

        //Sección de Student
        this.setNum_hours_week(studentSubject.getStudent().getNum_hours_week());
        this.setComments(studentSubject.getStudent().getComments());
        this.setBranch(studentSubject.getStudent().getBranch());
        //Sección de Subject
        this.setId_subject(studentSubject.getId_subject());
        this.setSubject(studentSubject.getSubject());
        this.setInitial_date(studentSubject.getInitial_date());
        this.setFinish_date(studentSubject.getFinish_date());
    }
}
