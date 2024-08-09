package com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations;

import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.RideRequest;
import com.bansal.project.ridewave.ridewaveApp.Repositories.DriverRepository;
import com.bansal.project.ridewave.ridewaveApp.Strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
        return driverRepository.findNearestDriver(rideRequest.getPickupLocation());
    }

}
