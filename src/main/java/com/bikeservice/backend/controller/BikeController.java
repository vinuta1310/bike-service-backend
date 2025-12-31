package com.bikeservice.backend.controller;

import com.bikeservice.backend.entity.Bike;

import com.bikeservice.backend.repository.BikeRepository;
import com.bikeservice.backend.repository.ServiceBookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bikes")
@CrossOrigin(origins = "*")
public class BikeController {

	@Autowired
	private BikeRepository bikeRepository;

	@Autowired
	private ServiceBookingRepository serviceBookingRepository;
	

    public BikeController(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @PostMapping
    public Bike addBike(@RequestBody Bike bike) {
        return bikeRepository.save(bike);
    }

    @GetMapping
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable Long id) {
        if (!bikeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        serviceBookingRepository.deleteByBikeId(id);
        bikeRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    // Update bike
    @PutMapping("/{id}")
    public Bike updateBike(@PathVariable Long id, @RequestBody Bike updatedBike) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bike not found with id " + id));

        bike.setBrand(updatedBike.getBrand());
        bike.setModel(updatedBike.getModel());
        bike.setRegistrationNumber(updatedBike.getRegistrationNumber());

        return bikeRepository.save(bike);
    }
}
