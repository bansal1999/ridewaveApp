package com.bansal.project.ridewave.ridewaveApp.Services;

import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.PaymentStatus;
import com.bansal.project.ridewave.ridewaveApp.Entities.Payment;
import com.bansal.project.ridewave.ridewaveApp.Entities.Ride;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
