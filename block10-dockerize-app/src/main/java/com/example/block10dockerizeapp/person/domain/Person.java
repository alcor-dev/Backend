package com.example.block10dockerizeapp.person.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Integer idPerson;

    @Column
    private int age;

    @Column
    private String city;

    @Column
    private String name;
}
