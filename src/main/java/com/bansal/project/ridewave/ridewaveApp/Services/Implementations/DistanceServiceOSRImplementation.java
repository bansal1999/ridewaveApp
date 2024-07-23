package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.Services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceOSRImplementation implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dst) {
//        TODO: Call the third party API OSRM to fetch the distance
        return 0;
    }
}
