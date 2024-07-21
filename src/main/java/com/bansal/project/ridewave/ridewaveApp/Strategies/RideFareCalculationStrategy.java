package com.bansal.project.ridewave.ridewaveApp.Strategies;

import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;

public interface RideFareCalculationStrategy {
    double calculateFare(RideRequestDTO rideRequestDTO);
}
