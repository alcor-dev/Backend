package com.example.block7crud;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

//Mediante las anotaciones otorgamos a la clase de una serie de características concretas
//Avisaremos de que usaremos esta clase con sus Getter y Setter mediante @Data
@Data
//Avisaremos de que esta clase es una entidad mediante Entity (teoría BBDD)
@Entity
//Esta clase será una tabla llamada Person dentro de la base de datos que iniciaremos
@Table(name="person")
public class Person implements Serializable {
//Podríamos acompañar las otras indicaciones con
// @NoArgsConstructor -> Indica que creará un constructor sin parámetros
// @AllArgsConstructor -> Indica que creará un constructor con todos los parámetros
    Person() {}

    Person(String id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    //Con @Id avisaremos que este campo es una columna de PK
    @Id
    private String id;

    //con @Column avisaremos de que este campo será una columna dentro de la tabla Person
    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String city;

}
