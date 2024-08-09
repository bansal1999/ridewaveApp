package com.bansal.project.ridewave.ridewaveApp.Services;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RideDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RiderDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;

import java.util.List;

public interface DriverService {

    RideDTO acceptRide(Long rideRequestId);
    RideDTO cancelRide(Long rideId);

    RideDTO startRide(Long rideId, String OTP);

    RideDTO endRide(Long rideId);

    RiderDTO rateRider(Long rideId, Integer rating);

    DriverDTO getMyProfile();

    List<RideDTO> getAllMyRides();

    Driver getCurrentDriver();

}
