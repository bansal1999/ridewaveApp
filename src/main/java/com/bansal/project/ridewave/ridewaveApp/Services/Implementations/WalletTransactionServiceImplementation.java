package com.bansal.project.ridewave.ridewaveApp.Services.Implementations;

import com.bansal.project.ridewave.ridewaveApp.Entities.WalletTransaction;
import com.bansal.project.ridewave.ridewaveApp.Repositories.WalletTransactionRepository;
import com.bansal.project.ridewave.ridewaveApp.Services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImplementation implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createWalletTransaction(WalletTransaction walletTransaction) {

        WalletTransaction walletTransaction = modelMapper.map(walletTransactionDTO, WalletTransaction.class);
        walletTransactionRepository.save(walletTransaction);


    }
}
