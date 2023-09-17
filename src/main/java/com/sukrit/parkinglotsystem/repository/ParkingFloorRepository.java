package com.sukrit.parkinglotsystem.repository;

import com.sukrit.parkinglotsystem.models.ParkingFloor;
import com.sukrit.parkinglotsystem.models.ParkingFloorStatus;
import com.sukrit.parkinglotsystem.models.ParkingSpot;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Long> {

  List<ParkingFloor> findParkingFloorByParkingFloorStatus(ParkingFloorStatus floorStatus);

  ParkingFloor findFirstByParkingFloorStatus(ParkingFloorStatus floorStatus);

}
