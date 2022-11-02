package com.example.block7crudvalidation;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SimpleStudentDTO extends Student {

    private int num_hours_week;

    private String comments;

    private String branch;

    public SimpleStudentDTO getStudentSimpleInfo(Student student) {
        this.setNum_hours_week(student.getNum_hours_week());
        this.setComments(student.getComments());
        this.setBranch(student.getBranch());
        return null;
    }

}
