package com.bansal.project.ridewave.ridewaveApp.Services;

import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.RideStatus;
import com.bansal.project.ridewave.ridewaveApp.Entities.Ride;
import com.bansal.project.ridewave.ridewaveApp.Entities.RideRequest;
import com.bansal.project.ridewave.ridewaveApp.Entities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDTO rideRequestDTO);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}
