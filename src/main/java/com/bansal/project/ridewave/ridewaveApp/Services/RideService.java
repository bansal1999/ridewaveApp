package com.bansal.project.ridewave.ridewaveApp.Services;

import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.RideStatus;
import com.bansal.project.ridewave.ridewaveApp.Entities.Ride;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDTO rideRequestDTO);

    Ride createNewRide(RideRequestDTO rideRequestDTO, Driver driver);

    Ride updateRideStatus(Long rideId, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
}
