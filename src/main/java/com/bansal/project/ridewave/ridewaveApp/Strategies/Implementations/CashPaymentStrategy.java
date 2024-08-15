package com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations;

import com.bansal.project.ridewave.ridewaveApp.Entities.Driver;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.TransactionMethod;
import com.bansal.project.ridewave.ridewaveApp.Entities.Payment;
import com.bansal.project.ridewave.ridewaveApp.Entities.Wallet;
import com.bansal.project.ridewave.ridewaveApp.Services.WalletService;
import com.bansal.project.ridewave.ridewaveApp.Strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//Rider  --> 100
//Driver --> 70  Deduct 30Rs from driver wallet

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {
    private final WalletService walletService;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

        Wallet driverWallet = walletService.findByUser(driver.getUser());
        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoney(driver.getUser(), platformCommission, null, payment.getRide(), TransactionMethod.RIDE);



    }
}
