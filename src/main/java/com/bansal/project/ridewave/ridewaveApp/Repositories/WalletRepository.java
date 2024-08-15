package com.bansal.project.ridewave.ridewaveApp.Repositories;

import com.bansal.project.ridewave.ridewaveApp.Entities.User;
import com.bansal.project.ridewave.ridewaveApp.Entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUser(User user);
}
