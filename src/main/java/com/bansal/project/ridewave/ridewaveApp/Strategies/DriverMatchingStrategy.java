package com.bansal.project.ridewave.ridewaveApp.Strategies;

import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {

     List<Driver> findMatchingDrivers(RideRequestDTO rideRequestDTO);
}
