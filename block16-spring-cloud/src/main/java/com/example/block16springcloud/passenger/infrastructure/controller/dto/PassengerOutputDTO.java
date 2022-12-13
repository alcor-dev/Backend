package com.example.block16springcloud.passenger.infrastructure.controller.dto;

import com.example.block16springcloud.passenger.domain.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PassengerOutputDTO implements Serializable {

    public PassengerOutputDTO(Passenger passenger) {
        this.setFirstName(passenger.getFirstName());
        this.setLastName(passenger.getLastName());
        this.setAge(passenger.getAge());
        this.setEmail(passenger.getEmail());
        this.setPhone(passenger.getPhone());
    }

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private String phone;
}
