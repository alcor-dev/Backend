package com.example.block7crudvalidation.teacher.infrastructure.controller.dto;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullTeacherDTO extends TeacherDTO {

    //Parte de Person

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

    //Parte de Teacher

    private int teacher_id;

    private String comments;

    private String branch;

    public FullTeacherDTO getFullTeacherInfo(Teacher teacher) {

        //Parte de Teacher
        this.setTeacher_id(teacher.getId_teacher());
        this.setComments(teacher.getComments());
        this.setBranch(teacher.getBranch());
        //Parte de Persona
        this.setUsername(teacher.getPerson().getUsername());
        this.setPassword(teacher.getPerson().getPassword());
        this.setName(teacher.getPerson().getName());
        this.setSurname(teacher.getPerson().getSurname());
        this.setCompany_email(teacher.getPerson().getCompany_email());
        this.setPersonal_email(teacher.getPerson().getPersonal_email());
        this.setCity(teacher.getPerson().getCity());
        this.setActive(teacher.getPerson().getActive());
        this.setCreated_date(teacher.getPerson().getCreated_date());
        this.setImage_url(teacher.getPerson().getImage_url());
        this.setTermination_date(teacher.getPerson().getTermination_date());
        return null;
    }
}