package com.bansal.project.ridewave.ridewaveApp.Strategies;

import com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations.DriverMatchingHighestRatedDriverStrategy;
import com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations.DriverMatchingNearestDriverStrategy;
import com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations.RiderDareDefaultFareCalculationStrategy;
import com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations.RiderFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RiderFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RiderDareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

    public RideFareCalculationStrategy getRideFareCalculationStrategy() {

        LocalTime surgeStartTime = LocalTime.of(18, 0);
        LocalTime surgeEndTime = LocalTime.of(21, 0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if (isSurgeTime) {
            return surgePricingFareCalculationStrategy;
        } else {
            return defaultFareCalculationStrategy;
        }

    }

    public DriverMatchingStrategy getDriverMatchingStrategy(double riderRating) {
        if (riderRating >= 4.5) {
            return highestRatedDriverStrategy;
        } else {
            return nearestDriverStrategy;
        }
    }

}
