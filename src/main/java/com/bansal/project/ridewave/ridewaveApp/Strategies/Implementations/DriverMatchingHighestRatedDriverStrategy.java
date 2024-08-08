package com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations;

import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.RideRequest;
import com.bansal.project.ridewave.ridewaveApp.Strategies.DriverMatchingStrategy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
        return null;
    }
}
