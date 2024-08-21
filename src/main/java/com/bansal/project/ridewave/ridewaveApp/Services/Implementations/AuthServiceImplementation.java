package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.SignupDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.UserDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.Role;
import com.bansal.project.ridewave.ridewaveApp.Entities.User;
import com.bansal.project.ridewave.ridewaveApp.Exceptions.ResourceNotFoundException;
import com.bansal.project.ridewave.ridewaveApp.Exceptions.RuntimeConflictException;
import com.bansal.project.ridewave.ridewaveApp.Repositories.UserRepository;
import com.bansal.project.ridewave.ridewaveApp.Services.AuthService;
import com.bansal.project.ridewave.ridewaveApp.Services.DriverService;
import com.bansal.project.ridewave.ridewaveApp.Services.RiderService;
import com.bansal.project.ridewave.ridewaveApp.Services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    @Transactional
    public UserDTO signup(SignupDTO signupDTO) {
        User user = userRepository.findByEmail(signupDTO.getEmail()).orElse(null);
        if (user != null) {
            throw new RuntimeConflictException("Cannot signup, already exists with email " + signupDTO.getEmail());
        }

        User mappedUser = modelMapper.map(signupDTO, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        // create user related entities
        riderService.createNerRider(savedUser);

        //Wallet related service
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public DriverDTO onboardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with: " + userId));

        if (!user.getRoles().contains(Role.RIDER)) {
            throw new IllegalArgumentException("User is not a rider");
        }

        Driver createDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(Role.DRIVER);
        userRepository.save(user);
        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDTO.class);
    }
}
 