package com.bansal.project.ridewave.ridewaveApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDTO {

    private UserDTO user;
    private Long id;
    private Double rating;

}

