package com.sukrit.parkinglotsystem.repository;

import com.sukrit.parkinglotsystem.models.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

}
