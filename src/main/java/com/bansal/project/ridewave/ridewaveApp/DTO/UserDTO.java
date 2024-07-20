package com.bansal.project.ridewave.ridewaveApp.DTO;

import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;
    private String email;
    private String password;

    private Set<Role> roles;

}
