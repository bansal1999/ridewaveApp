package com.bansal.project.ridewave.ridewaveApp.Services;


import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.TransactionMethod;
import com.bansal.project.ridewave.ridewaveApp.Entities.Ride;
import com.bansal.project.ridewave.ridewaveApp.Entities.User;
import com.bansal.project.ridewave.ridewaveApp.Entities.Wallet;

public interface WalletService {
    Wallet addMoney(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoney(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    void withdrawMoney();

    Wallet findWallet(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);
}
