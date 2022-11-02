package com.example.block7crudvalidation.student.domain;

import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_student;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    Person person;

    @Column
    private int num_hours_week;

    @Column
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher")
    Teacher teacher;

    @Column
    private String branch;

}
