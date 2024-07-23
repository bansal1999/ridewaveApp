package com.bansal.project.ridewave.ridewaveApp.DTO;


import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.PaymentMethod;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.RideRequestStatus;
import com.bansal.project.ridewave.ridewaveApp.Entities.Rider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDTO {

    private Long id;

    private PointDTO pickupLocation;

    private PointDTO dropOffLocation;

    private LocalDateTime requestedTime;

    private RiderDTO rider;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;


}
