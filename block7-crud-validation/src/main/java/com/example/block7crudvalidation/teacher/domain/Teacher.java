package com.example.block7crudvalidation.teacher.domain;

import com.example.block7crudvalidation.person.domain.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_teacher;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    Person person;

    @Column
    private String comments;

    @Column
    private String branch;
}