package com.example.block7crudvalidation;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id_teacher;

    @OneToOne
    @JoinColumn(name = "id_person")
    Person person;

    @Column
    private String comments;

    @Column
    private String branch;
}
