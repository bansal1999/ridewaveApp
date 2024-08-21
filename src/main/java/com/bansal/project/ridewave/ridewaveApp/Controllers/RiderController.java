package com.bansal.project.ridewave.ridewaveApp.Controllers;

import com.bansal.project.ridewave.ridewaveApp.DTO.*;
import com.bansal.project.ridewave.ridewaveApp.Services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/riders")
@RequiredArgsConstructor
public class RiderController {
    private final RiderService riderService;

    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDTO> requestRide(@RequestBody RideRequestDTO rideRequestDTO) {
        return ResponseEntity.ok(riderService.requestRide(rideRequestDTO));
    }

    @PostMapping("/cancelRide/{rideId}")
    public ResponseEntity<RideDTO> cancelRide(@PathVariable Long rideId) {
        return ResponseEntity.ok(riderService.cancelRide(rideId));
    }

    @PostMapping("/rateDriver")
    public ResponseEntity<DriverDTO> rateDriver(@RequestBody RateDTO rateDTO) {
        return ResponseEntity.ok(riderService.rateDriver(rateDTO.getRideId(), rateDTO.getRating()));

    }

    @GetMapping("/getMyProfile")
    public ResponseEntity<RiderDTO> getMyProfile() {
        return ResponseEntity.ok(riderService.getMyProfile());
    }

    @GetMapping("/getMyRides")
    public ResponseEntity<Page<RideDTO>> getMyRides(@RequestParam(defaultValue = "0") Integer pageOffset,
                                                    @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize,
                Sort.by(Sort.Direction.DESC, "createdTime", "id"));
        return ResponseEntity.ok(riderService.getAllMyRides(pageRequest));
    }

    @PostMapping("/rateDriver/{driverId}/{rating}")
    public ResponseEntity<DriverDTO> rateDriver(@PathVariable Long driverId, @PathVariable Integer rating) {
        return ResponseEntity.ok(riderService.rateDriver(driverId, rating));
    }

}
