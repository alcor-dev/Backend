package com.example.block7crudvalidation.person.infrastructure.controller.dto;

import com.example.block7crudvalidation.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO implements Serializable {

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

    public PersonDTO getPersonInfo(Person person) {

        //Parte de Persona
        this.setUsername(person.getUsername());
        this.setPassword(person.getPassword());
        this.setName(person.getName());
        this.setSurname(person.getSurname());
        this.setCompany_email(person.getCompany_email());
        this.setPersonal_email(person.getPersonal_email());
        this.setCity(person.getCity());
        this.setActive(person.getActive());
        this.setCreated_date(person.getCreated_date());
        this.setImage_url(person.getImage_url());
        this.setTermination_date(person.getTermination_date());
        return null;
    }
}
