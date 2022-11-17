package com.example.block10dockerizeapp.person.infrastructure.controller.dto;

import com.example.block10dockerizeapp.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;


//Creating our own DTO class just for this exercise purpose and testing
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDTO implements Serializable {

    @Column
    private int age;

    @Column
    private String city;

    @Column
    private String name;


    //Method to transfer info from the Person class into its own DTO
    //Included the .toString() just for showing purposes
    public void transferPersonToDto(Person person) {
        this.setAge(person.getAge());
        this.setCity(person.getCity());
        this.setName(person.getName());
    }

}



