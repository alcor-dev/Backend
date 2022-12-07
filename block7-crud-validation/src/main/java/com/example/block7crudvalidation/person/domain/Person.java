package com.example.block7crudvalidation.person.domain;

import javax.persistence.*;

import com.example.block7crudvalidation.person.infrastructure.controller.dto.PersonDTO;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;


@Data
@Entity
@Builder
@Table(name = "person")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_person;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String company_email;

    @Column
    private String personal_email;

    @Column
    private String city;

    @Column
    private Boolean active;

    @Column
    private Date created_date;

    @Column
    private String image_url;

    @Column
    private Date termination_date;

    @Column
    private Boolean admin;

    //This methods gets some person and creates a new instance, doesn't make any sense but.. IT WORKS
    //**THUNDER AND LIGHTNING IN THE BACKGROUND*
    public Person(Person person) {
        this.setId_person(person.getId_person());
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
    }

    public Boolean checkData() throws Exception {
        if ((this.username.length() > 10) && (username.length() < 6)) {
            throw new Exception("Usuario no puede ser nulo");
        } if (this.password == null) {
            throw new Exception("Password no puede ser nula");
        } if (this.name == null) {
            throw new Exception("El nombre no puede ser nulo");
        } if (this.company_email == null) {
            throw new Exception("El mail de la compañía no puede ser nulo");
        } if (this.personal_email == null) {
            throw new Exception("El mail personal no puede ser nulo");
        } if (this.city == null) {
            throw new Exception("La ciudad no puede ser nula");
        } if (this.active == null) {
            throw new Exception("La actividad no puede ser nula");
        } if (this.created_date == null) {
            throw new Exception("La fecha de creación no puede ser nula");
        } else {
            return true;
        }
    }

    public PersonDTO fillDTO(PersonDTO personDTO) {

        this.setUsername(personDTO.getUsername());
        this.setPassword(personDTO.getPassword());
        this.setName(personDTO.getName());
        this.setSurname(personDTO.getSurname());
        this.setCompany_email(personDTO.getCompany_email());
        this.setPersonal_email(personDTO.getPersonal_email());
        this.setCity(personDTO.getCity());
        this.setActive(personDTO.getActive());
        this.setCreated_date(personDTO.getCreated_date());
        this.setImage_url(personDTO.getImage_url());
        this.setTermination_date(personDTO.getTermination_date());
        return null;
    }
}
