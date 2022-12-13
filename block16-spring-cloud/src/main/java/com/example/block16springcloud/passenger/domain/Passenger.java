package com.example.block16springcloud.passenger.domain;

import com.example.block16springcloud.passenger.infrastructure.controller.dto.PassengerInputDTO;
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
public class Passenger implements Serializable {

    public Passenger (PassengerInputDTO passengerInputDTO) {
        this.setFirstName(passengerInputDTO.getFirstName());
        this.setLastName(passengerInputDTO.getLastName());
        this.setAge(passengerInputDTO.getAge());
        this.setEmail(passengerInputDTO.getEmail());
        this.setPhone(passengerInputDTO.getPhone());
    }

    public Passenger (Integer idPassenger) {
        this.setIdPassenger(idPassenger);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPassenger;

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
