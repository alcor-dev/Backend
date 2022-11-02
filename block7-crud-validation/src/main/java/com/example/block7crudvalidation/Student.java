package com.example.block7crudvalidation;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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

//    @OneToMany
//    private List<StudentSubject> subjects;
}
