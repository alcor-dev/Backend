package com.example.block7crudvalidation.teacher.infrastructure.controller.dto;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO implements Serializable {

    private String comments;
    private String branch;

    public void getTeacherSimpleInfo(Teacher teacher) {

        this.setComments(teacher.getComments());
        this.setBranch(teacher.getBranch());

    }
}
