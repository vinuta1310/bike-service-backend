package com.bikeservice.backend.controller;

import com.bikeservice.backend.entity.Bike;
import com.bikeservice.backend.entity.ServiceBooking;
import com.bikeservice.backend.repository.BikeRepository;
import com.bikeservice.backend.repository.ServiceBookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-bookings")
@CrossOrigin(origins = "*")
public class ServiceBookingController {

    private final ServiceBookingRepository serviceBookingRepository;
    private final BikeRepository bikeRepository;

    public ServiceBookingController(ServiceBookingRepository serviceBookingRepository, BikeRepository bikeRepository) {
        this.serviceBookingRepository = serviceBookingRepository;
        this.bikeRepository = bikeRepository;
    }

    // Add a service booking
    @PostMapping
    public ServiceBooking addBooking(@RequestBody ServiceBooking booking) {
        Long bikeId = booking.getBike().getId();
        Bike bike = bikeRepository.findById(bikeId)
                .orElseThrow(() -> new RuntimeException("Bike not found with id " + bikeId));
        booking.setBike(bike);
        return serviceBookingRepository.save(booking);
    }

    // Get all bookings
    @GetMapping
    public List<ServiceBooking> getAllBookings() {
        return serviceBookingRepository.findAll();
    }
}