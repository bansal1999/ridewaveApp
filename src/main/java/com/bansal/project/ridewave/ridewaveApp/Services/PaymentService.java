package com.bansal.project.ridewave.ridewaveApp.Services;

import com.bansal.project.ridewave.ridewaveApp.Entities.Payment;
import com.bansal.project.ridewave.ridewaveApp.Entities.Ride;

public interface PaymentService {

    void processPayment(Payment payment);

    Payment createNewPayment(Ride ride);
}
