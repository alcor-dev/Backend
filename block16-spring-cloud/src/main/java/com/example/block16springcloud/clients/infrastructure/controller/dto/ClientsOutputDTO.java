package com.example.block16springcloud.clients.infrastructure.controller.dto;

import com.example.block16springcloud.clients.domain.Clients;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientsOutputDTO implements Serializable {

    public ClientsOutputDTO(Clients clients) {
        this.setFirstName(clients.getFirstName());
        this.setLastName(clients.getLastName());
        this.setAge(clients.getAge());
        this.setEmail(clients.getEmail());
        this.setPhone(clients.getPhone());
    }

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private String phone;
}
