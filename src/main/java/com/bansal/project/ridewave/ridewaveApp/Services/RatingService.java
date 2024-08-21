package com.bansal.project.ridewave.ridewaveApp.Services;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RiderDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.Ride;
import com.bansal.project.ridewave.ridewaveApp.Entities.Rider;

public interface RatingService {
    DriverDTO rateDriver(Ride ride, Integer rating);

    RiderDTO rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);

}
