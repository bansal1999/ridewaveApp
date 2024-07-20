package com.bansal.project.ridewave.ridewaveApp.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupDTO {

    private String name;
    private String password;
    private String email;
}
