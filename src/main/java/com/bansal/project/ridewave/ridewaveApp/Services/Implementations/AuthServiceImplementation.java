package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.SignupDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.UserDTO;
import com.bansal.project.ridewave.ridewaveApp.Services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService {
    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public UserDTO signup(SignupDTO signupDTO) {
        return null;
    }

    @Override
    public DriverDTO onboardNewDriver(Long userId) {
        return null;
    }
}
