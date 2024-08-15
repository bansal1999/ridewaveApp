package com.bansal.project.ridewave.ridewaveApp.Services;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RideDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RiderDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Rider;
import com.bansal.project.ridewave.ridewaveApp.Entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RiderService {

    RideRequestDTO requestRide(RideRequestDTO rideRequestDTO);

    RideDTO cancelRide(Long rideId);

    DriverDTO rateDriver(Long rideId, Integer rating);

    RiderDTO getMyProfile();

    Page<RideDTO> getAllMyRides(PageRequest pageRequest);

    Rider createNerRider(User user);

    Rider getCurrentRider();


}
