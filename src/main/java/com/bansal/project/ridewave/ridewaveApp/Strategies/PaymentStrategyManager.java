package com.bansal.project.ridewave.ridewaveApp.Strategies;


import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.PaymentMethod;
import com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations.CashPaymentStrategy;
import com.bansal.project.ridewave.ridewaveApp.Strategies.Implementations.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;


    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
        return switch (paymentMethod) {
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }

}
