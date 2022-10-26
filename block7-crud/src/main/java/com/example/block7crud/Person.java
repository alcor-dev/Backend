package com.example.block7crud;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="person")
public class Person implements Serializable {

    Person() {}

    Person(String id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String city;

}
