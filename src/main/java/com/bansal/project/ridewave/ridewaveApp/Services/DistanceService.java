package com.bansal.project.ridewave.ridewaveApp.Services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
    double calculateDistance(Point src, Point dst);
}
