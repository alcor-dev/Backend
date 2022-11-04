package com.example.block7crudvalidation.person.infrastructure.controller.dto;

import com.example.block7crudvalidation.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPersonDTO extends PersonDTO{

    //Parámetros de Person

    private String username;

    private String password;

    private String name;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private Boolean active;

    private Date created_date;

    private String image_url;

    private Date termination_date;

    //Parámetros de Student

    private int id_student;

    private int num_hours_week;

    private String comments;

    private String branch;

    public StudentPersonDTO getStudentPersonInfo(Student student) {
        //Parte de Student
        this.setId_student(student.getId_student());
        this.setNum_hours_week(student.getNum_hours_week());
        this.setComments(student.getComments());
        this.setBranch(student.getBranch());
        //Parte de Persona
        this.setUsername(student.getPerson().getUsername());
        this.setPassword(student.getPerson().getPassword());
        this.setName(student.getPerson().getName());
        this.setSurname(student.getPerson().getSurname());
        this.setCompany_email(student.getPerson().getCompany_email());
        this.setPersonal_email(student.getPerson().getPersonal_email());
        this.setCity(student.getPerson().getCity());
        this.setActive(student.getPerson().getActive());
        this.setCreated_date(student.getPerson().getCreated_date());
        this.setImage_url(student.getPerson().getImage_url());
        this.setTermination_date(student.getPerson().getTermination_date());
        return null;
    }
}
