package com.bansal.project.ridewave.ridewaveApp.Strategies;

import com.bansal.project.ridewave.ridewaveApp.Entities.Payment;

public interface PaymentStrategy {

    Double PLATFORM_COMMISSION = 0.3;

    void processPayment(Payment payment);
}
