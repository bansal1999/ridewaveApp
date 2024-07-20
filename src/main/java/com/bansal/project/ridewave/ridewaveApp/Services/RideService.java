package com.bansal.project.ridewave.ridewaveApp.Services;

import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Ride;

public interface RideService {

    Ride getRideById();

    void matchWithDrivers(RideRequestDTO rideRequestDTO);

}
