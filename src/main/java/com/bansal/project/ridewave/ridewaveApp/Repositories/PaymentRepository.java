package com.bansal.project.ridewave.ridewaveApp.Repositories;

import com.bansal.project.ridewave.ridewaveApp.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
