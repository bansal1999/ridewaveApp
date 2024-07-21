package com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations;

import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDrivers(RideRequestDTO rideRequestDTO) {
        return null;
    }
}
