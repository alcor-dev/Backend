package com.example.block7crudvalidation.student.infrastructure.controller.dto;

import com.example.block7crudvalidation.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements Serializable {

    private int num_hours_week;

    private String comments;

    private String branch;

    public void getStudentSimpleInfo(Student student) {
        this.setNum_hours_week(student.getNum_hours_week());
        this.setComments(student.getComments());
        this.setBranch(student.getBranch());

    }

}
