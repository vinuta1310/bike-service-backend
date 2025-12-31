
package com.bikeservice.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String serviceType; // e.g., "Oil Change", "Repair"
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "bike_id")
    private Bike bike;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public Bike getBike() { return bike; }
    public void setBike(Bike bike) { this.bike = bike; }
}