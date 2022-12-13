package com.example.block16springcloud.passenger.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PassengerInputDTO implements Serializable {

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private String phone;
}
