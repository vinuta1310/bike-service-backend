
package com.bikeservice.backend.repository;

import com.bikeservice.backend.entity.ServiceBooking;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM ServiceBooking s WHERE s.bike.id = :bikeId")
    void deleteByBikeId(@Param("bikeId") Long bikeId);
}