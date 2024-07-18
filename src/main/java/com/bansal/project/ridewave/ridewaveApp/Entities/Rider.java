package com.bansal.project.ridewave.ridewaveApp.Entities;

import jakarta.persistence.*;

@Entity
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Double rating;


}
