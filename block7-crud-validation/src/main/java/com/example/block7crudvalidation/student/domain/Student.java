package com.example.block7crudvalidation.student.domain;

import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_student;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    Person person;

    @Column
    private int num_hours_week;

    @Column
    private String comments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher")
    Teacher teacher;

    @Column
    private String branch;

}
