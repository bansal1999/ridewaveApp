package com.bansal.project.ridewave.ridewaveApp.Entities;

import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.TransactionMethod;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    @OneToOne
    private Ride ride;

    private String transactionId;

    @ManyToOne
    private Wallet wallet;

    @CreationTimestamp
    private LocalDateTime timestamp;


}
