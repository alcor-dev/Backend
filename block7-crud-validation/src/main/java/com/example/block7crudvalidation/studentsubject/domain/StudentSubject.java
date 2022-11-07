package com.example.block7crudvalidation.studentsubject.domain;

import com.example.block7crudvalidation.student.domain.Student;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "subject")
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StudentSubject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_subject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_student")
    Student student;

    @Column
    private String subject;

    @Column
    private Date initial_date;

    @Column
    private Date finish_date;
}
