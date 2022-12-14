package com.example.block16springcloud2nd.passenger.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Passenger implements Serializable {

    private Integer idPassenger;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private String phone;

}
