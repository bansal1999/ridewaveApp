package com.bansal.project.ridewave.ridewaveApp.DTO;

import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.TransactionMethod;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WalletTransactionDTO {
    private Long id;
    private Double amount;
    private TransactionType transactionType;
    private TransactionMethod transactionMethod;
    private RideDTO rideDTO;
    private String transactionId;
    private WalletDTO walletDTO;
    private LocalDateTime timestamp;
}
