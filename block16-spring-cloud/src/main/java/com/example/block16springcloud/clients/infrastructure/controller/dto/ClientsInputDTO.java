package com.example.block16springcloud.clients.infrastructure.controller.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientsInputDTO implements Serializable {

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private String phone;
}
