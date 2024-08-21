package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RideDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RiderDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.*;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.RideRequestStatus;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.RideStatus;
import com.bansal.project.ridewave.ridewaveApp.Exceptions.ResourceNotFoundException;
import com.bansal.project.ridewave.ridewaveApp.Repositories.RideRequestRepository;
import com.bansal.project.ridewave.ridewaveApp.Repositories.RiderRepository;
import com.bansal.project.ridewave.ridewaveApp.Services.DriverService;
import com.bansal.project.ridewave.ridewaveApp.Services.RatingService;
import com.bansal.project.ridewave.ridewaveApp.Services.RideService;
import com.bansal.project.ridewave.ridewaveApp.Services.RiderService;
import com.bansal.project.ridewave.ridewaveApp.Strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImplementation implements RiderService {

    private final ModelMapper modelMapper;
    private final RideStrategyManager rideStrategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;
    private final RideService rideService;
    private final DriverService driverService;
    private final RatingService ratingService;

    @Override
    @Transactional
    public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);
        log.info(rideRequest.toString());
        //TODO: pickup and drop location are same coordinates -- FIX THAT
        Double fare = rideStrategyManager.getRideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
        List<Driver> drivers = rideStrategyManager
                .getDriverMatchingStrategy(rider.getRating()).findMatchingDrivers(rideRequest);

        // TODO: SEND NOTIFICATION TO ALL THE DRIVERS  about this ride

        return modelMapper.map(savedRideRequest, RideRequestDTO.class);
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        Rider currentRider = getCurrentRider();
        Ride ride = rideService.getRideById(rideId);

        if (!currentRider.equals(ride.getRider())) {
            throw new IllegalStateException("Rider does not own this ride" + rideId);
        }

        if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
            throw new RuntimeException("Ride Status is not confirmed " + ride.getRideStatus());
        }

        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.CANCELLED);
        driverService.updateDriverAvailability(ride.getDriver(), true);

        return modelMapper.map(savedRide, RideDTO.class);
    }

    @Override
    public DriverDTO rateDriver(Long rideId, Integer rating) {
        Ride ride = rideService.getRideById(rideId);
        Rider rider = getCurrentRider();

        if (!rider.equals(ride.getDriver())) {
            throw new RuntimeException("Current Ride does not belong to current Rider");
        }
        if (!ride.getRideStatus().equals(RideStatus.ENDED)) {
            throw new RuntimeException("Ride Status is not ENDED hence cannot be rated " + ride.getRideStatus());
        }
        return ratingService.rateDriver(ride, rating);
    }

    @Override
    public RiderDTO getMyProfile() {
        Rider currentRider = getCurrentRider();
        return modelMapper.map(currentRider, RiderDTO.class);
    }

    @Override
    public Page<RideDTO> getAllMyRides(PageRequest pageRequest) {
        Rider currentRider = getCurrentRider();
        return rideService.getAllRidesOfRider(currentRider, pageRequest).map(
                ride -> modelMapper.map(ride, RideDTO.class)
        );
    }

    @Override
    public Rider createNerRider(User user) {
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        //TODO IMPLEMENTATION SPRING SECURITY
        return riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(
                "No rider with ID: " + 1
        ));
    }
}
