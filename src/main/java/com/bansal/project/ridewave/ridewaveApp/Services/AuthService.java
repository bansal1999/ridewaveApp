package com.bansal.project.ridewave.ridewaveApp.Services;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.SignupDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.UserDTO;

public interface AuthService {
    String login(String email, String password);

    UserDTO signup(SignupDTO signupDTO);

    DriverDTO onboardNewDriver(Long userId, String vehicleId);
}
