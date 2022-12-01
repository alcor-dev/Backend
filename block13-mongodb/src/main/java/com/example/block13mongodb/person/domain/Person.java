package com.example.block13mongodb.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class Person implements Serializable {

    @Id
    private Integer idMongo;

    private String name;

    private Integer age;

    private String username;

    private String city;

}
