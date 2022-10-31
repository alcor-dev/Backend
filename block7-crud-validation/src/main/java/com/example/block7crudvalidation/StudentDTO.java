package com.example.block7crudvalidation;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements Serializable {

    private int num_hours_week;

    private String comments;

    private String branch;

}
