package com.example.block16springcloud.clients.domain;

import com.example.block16springcloud.clients.infrastructure.controller.dto.ClientsInputDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clients implements Serializable {

    public Clients (ClientsInputDTO clientsInputDTO) {
        this.setFirstName(clientsInputDTO.getFirstName());
        this.setLastName(clientsInputDTO.getLastName());
        this.setAge(clientsInputDTO.getAge());
        this.setEmail(clientsInputDTO.getEmail());
        this.setPhone(clientsInputDTO.getPhone());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idClients;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @Column
    private String email;

    @Column
    private String phone;


}
