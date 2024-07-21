package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RideDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RiderDTO;
import com.bansal.project.ridewave.ridewaveApp.Services.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImplementation implements DriverService {
    @Override
    public RideDTO acceptRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO startRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDTO rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getAllMyRides() {
        return null;
    }
}
