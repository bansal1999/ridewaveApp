package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.Entities.RideRequest;
import com.bansal.project.ridewave.ridewaveApp.Exceptions.ResourceNotFoundException;
import com.bansal.project.ridewave.ridewaveApp.Repositories.RideRequestRepository;
import com.bansal.project.ridewave.ridewaveApp.Services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImplementation implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not fond of id: " + rideRequestId));
    }

    @Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found of id: " + rideRequest.getId()));
        rideRequestRepository.save(rideRequest);
    }
}
