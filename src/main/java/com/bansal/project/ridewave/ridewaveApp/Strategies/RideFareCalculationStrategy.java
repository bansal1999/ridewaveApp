package com.bansal.project.ridewave.ridewaveApp.Strategies;

import com.bansal.project.ridewave.ridewaveApp.Entities.RideRequest;

public interface RideFareCalculationStrategy {

    static final double RIDE_FARE_MULTIPLIER = 10;
    double calculateFare(RideRequest rideRequest);
}
