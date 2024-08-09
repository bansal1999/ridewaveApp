package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RideDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RiderDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.RideRequestStatus;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.RideStatus;
import com.bansal.project.ridewave.ridewaveApp.Entities.Ride;
import com.bansal.project.ridewave.ridewaveApp.Entities.RideRequest;
import com.bansal.project.ridewave.ridewaveApp.Exceptions.ResourceNotFoundException;
import com.bansal.project.ridewave.ridewaveApp.Repositories.DriverRepository;
import com.bansal.project.ridewave.ridewaveApp.Services.DriverService;
import com.bansal.project.ridewave.ridewaveApp.Services.RideRequestService;
import com.bansal.project.ridewave.ridewaveApp.Services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImplementation implements DriverService {

    private final RideRequestService rideRequestService;
    private final DriverRepository driverRepository;
    private final RideService rideService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public RideDTO acceptRide(Long rideRequestId) {
        RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);

        if (!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
            throw new RuntimeException("RideRequest CANNOT BE ACCEPTED, " + rideRequest.getRideRequestStatus());
        }

        Driver currentDriver = getCurrentDriver();
        if (!currentDriver.getAvailable()) {
            throw new RuntimeException("Current Driver is not available");
        }
        currentDriver.setAvailable(false);
        Driver savedDriver = driverRepository.save(currentDriver);
        Ride ride = rideService.createNewRide(rideRequest, savedDriver);
        return modelMapper.map(ride, RideDTO.class);
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO startRide(Long rideId, String OTP) {
        Ride ride = rideService.getRideById(rideId);
        Driver driver = getCurrentDriver();

        if (!driver.equals(ride.getDriver())) {
            throw new RuntimeException("Ride does not belong to current Driver");
        }

        if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
            throw new RuntimeException("Ride Status is not confrimed " + ride.getRideStatus());
        }

        if (!OTP.equals(ride.getOtp())) {
            throw new RuntimeException("Invalid OTP");
        }
        ride.setStartedAt(LocalDateTime.now());
        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);
        return modelMapper.map(savedRide, RideDTO.class);

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

    @Override
    public Driver getCurrentDriver() {
        //TODO: implement spring security
        return driverRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("No driver found"));
    }
}
