package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.SignupDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.UserDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.Role;
import com.bansal.project.ridewave.ridewaveApp.Entities.User;
import com.bansal.project.ridewave.ridewaveApp.Exceptions.RuntimeConflictException;
import com.bansal.project.ridewave.ridewaveApp.Repositories.UserRepository;
import com.bansal.project.ridewave.ridewaveApp.Services.AuthService;
import com.bansal.project.ridewave.ridewaveApp.Services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public UserDTO signup(SignupDTO signupDTO) {
        userRepository.findByEmail(signupDTO.getEmail()).orElseThrow(() ->
                new RuntimeConflictException("User already exists with this email " + signupDTO.getEmail()));


        User mappedUser = modelMapper.map(signupDTO, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        // create user related enitities
        riderService.createNerRider(savedUser);

//        TODO: ADD WALLET RELATED SERVICE

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public DriverDTO onboardNewDriver(Long userId) {
        return null;
    }
}
