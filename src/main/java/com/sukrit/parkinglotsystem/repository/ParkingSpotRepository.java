package com.sukrit.parkinglotsystem.repository;

import com.sukrit.parkinglotsystem.models.ParkingFloor;
import com.sukrit.parkinglotsystem.models.ParkingSpot;
import com.sukrit.parkinglotsystem.models.ParkingSpotStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

  List<ParkingSpot> findParkingSpotsByParkingFloor(ParkingFloor parkingFloor);

  ParkingSpot findFirstByParkingFloorAndParkingSpotStatus(ParkingFloor parkingFloor,
      ParkingSpotStatus parkingSpotStatus);

}
