package com.bansal.project.ridewave.ridewaveApp.Entities;

import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.PaymentMethod;
import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @OneToOne(fetch = FetchType.LAZY)
    private Ride ride;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @CreationTimestamp
    private LocalDateTime paymentTime;

}
