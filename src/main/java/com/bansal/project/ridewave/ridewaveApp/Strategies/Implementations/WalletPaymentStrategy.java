package com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations;

import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.PaymentStatus;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.TransactionMethod;
import com.bansal.project.ridewave.ridewaveApp.Entities.Payment;
import com.bansal.project.ridewave.ridewaveApp.Entities.Rider;
import com.bansal.project.ridewave.ridewaveApp.Repositories.PaymentRepository;
import com.bansal.project.ridewave.ridewaveApp.Services.Implementations.PaymentServiceImplementation;
import com.bansal.project.ridewave.ridewaveApp.Services.PaymentService;
import com.bansal.project.ridewave.ridewaveApp.Services.WalletService;
import com.bansal.project.ridewave.ridewaveApp.Strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Rider Balance 232, Driver Balance 500
// Ride cost = 100, Commission = 30
// Rider --> 232 -100 = 132
// Driver --> 500 (100 - 30) = 570

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoney(rider.getUser(), payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);

        double driverCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);
        walletService.addMoney(driver.getUser(), driverCut, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
