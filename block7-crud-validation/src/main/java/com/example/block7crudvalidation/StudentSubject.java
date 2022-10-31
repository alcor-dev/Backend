package com.example.block7crudvalidation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "student_subject")
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id_subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student student;

    @Column
    private String subject;

    @Column
    private Date initial_date;

    @Column
    private Date finish_date;
}
