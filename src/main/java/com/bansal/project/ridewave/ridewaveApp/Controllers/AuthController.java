package com.bansal.project.ridewave.ridewaveApp.Controllers;

import com.bansal.project.ridewave.ridewaveApp.DTO.SignupDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.UserDTO;
import com.bansal.project.ridewave.ridewaveApp.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    UserDTO signup(@RequestBody SignupDTO signupDTO) {
        return authService.signup(signupDTO);
    }
}
