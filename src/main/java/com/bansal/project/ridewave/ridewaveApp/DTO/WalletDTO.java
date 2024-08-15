package com.bansal.project.ridewave.ridewaveApp.DTO;

import lombok.Data;

import java.util.List;


@Data
public class WalletDTO {
    private Long id;

    private UserDTO userDTO;

    private List<WalletTransactionDTO> walletTransactions;

    private Double balance;
}
