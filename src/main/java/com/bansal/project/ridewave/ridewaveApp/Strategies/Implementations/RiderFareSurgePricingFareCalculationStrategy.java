package com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations;

import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;
import com.bansal.project.ridewave.ridewaveApp.Strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RiderFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDTO rideRequestDTO) {
        return 0;
    }
}
