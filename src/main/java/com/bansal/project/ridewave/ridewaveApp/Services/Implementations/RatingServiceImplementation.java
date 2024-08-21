package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.DTO.DriverDTO;
import com.bansal.project.ridewave.ridewaveApp.DTO.RiderDTO;
import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.Rating;
import com.bansal.project.ridewave.ridewaveApp.Entities.Ride;
import com.bansal.project.ridewave.ridewaveApp.Entities.Rider;
import com.bansal.project.ridewave.ridewaveApp.Exceptions.ResourceNotFoundException;
import com.bansal.project.ridewave.ridewaveApp.Repositories.DriverRepository;
import com.bansal.project.ridewave.ridewaveApp.Repositories.RatingRepository;
import com.bansal.project.ridewave.ridewaveApp.Repositories.RiderRepository;
import com.bansal.project.ridewave.ridewaveApp.Services.RatingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImplementation implements RatingService {

    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final ModelMapper modelMapper;

    @Override
    public DriverDTO rateDriver(Ride ride, Integer rating) {
        Driver driver = ride.getDriver();
        Rating ratingObject = ratingRepository.findByRide(ride).orElseThrow(() -> new ResourceNotFoundException("Rating not found with the id: " + ride.getId()));
        if (ratingObject.getDriverRating() != null)
            throw new IllegalArgumentException("Rating already exists for the ride");
        ratingObject.setDriverRating(rating);
        ratingRepository.save(ratingObject);
        Double newRating = ratingRepository.findByDriver(driver)
                .stream().mapToDouble(Rating::getDriverRating)
                .average().orElse(0.0);

        driver.setRating(newRating);
        Driver savedDriver = driverRepository.save(driver);
        return modelMapper.map(savedDriver, DriverDTO.class);

    }

    @Override
    public RiderDTO rateRider(Ride ride, Integer rating) {
        Rider rider = ride.getRider();
        Rating ratingObject = ratingRepository.findByRide(ride).orElseThrow(() -> new ResourceNotFoundException("Rating not found with the id: " + ride.getId()));
        if (ratingObject.getRiderRating() != null)
            throw new IllegalArgumentException("Rating already exists for the ride");
        ratingObject.setRiderRating(rating);
        ratingRepository.save(ratingObject);
        Double newRating = ratingRepository.findByRider(rider)
                .stream().mapToDouble(Rating::getRiderRating)
                .average().orElse(0.0);

        rider.setRating(newRating);
        Rider savedRider = riderRepository.save(rider);
        return modelMapper.map(savedRider, RiderDTO.class);

    }

    @Override
    public void createNewRating(Ride ride) {
        Rating rating = Rating.builder()
                .rider(ride.getRider())
                .driver(ride.getDriver())
                .ride(ride)
                .build();
        ratingRepository.save(rating);

    }
}
