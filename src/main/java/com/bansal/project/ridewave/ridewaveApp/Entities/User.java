package com.bansal.project.ridewave.ridewaveApp.Entities;

import com.bansal.project.ridewave.ridewaveApp.Entities.Enums.Role;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;
    @Column(unique = true)
    private String email;

    private String password;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

}
