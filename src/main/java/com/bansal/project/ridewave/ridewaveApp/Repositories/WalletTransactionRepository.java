package com.bansal.project.ridewave.ridewaveApp.Repositories;

import com.bansal.project.ridewave.ridewaveApp.Entities.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
}
