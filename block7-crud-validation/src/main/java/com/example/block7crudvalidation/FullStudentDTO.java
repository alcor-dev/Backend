package com.example.block7crudvalidation;

import java.io.Serializable;
import java.sql.Date;

public class FullStudentDTO implements Serializable {

    //Parte de Person

    private String username;

    private String password;

    private String name;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private Boolean active;

    private Date created_date;

    private String image_url;

    private Date termination_date;

    //Parte de Student

    private int num_hours_week;

    private String comments;

    private String branch;
}
