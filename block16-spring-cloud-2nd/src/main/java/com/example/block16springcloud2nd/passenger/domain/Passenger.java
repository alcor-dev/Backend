package com.example.block16springcloud2nd.passenger.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
