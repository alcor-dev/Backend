package com.example.block7crudvalidation.person.infrastructure.controller.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;


@Data
@Entity
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
}
