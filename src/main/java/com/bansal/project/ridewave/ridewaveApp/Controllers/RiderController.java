package com.bansal.project.ridewave.ridewaveApp.Controllers;

import com.bansal.project.ridewave.ridewaveApp.DTO.RideRequestDTO;
import com.bansal.project.ridewave.ridewaveApp.Services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/riders")
@RequiredArgsConstructor
public class RiderController {
    private final RiderService riderService;

    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDTO> requestRide(@RequestBody RideRequestDTO rideRequestDTO) {

        return ResponseEntity.ok(riderService.requestRide(rideRequestDTO));

    }
}
