package com.sukrit.parkinglotsystem.service;


import com.sukrit.parkinglotsystem.dto.ParkingLotDTO;
import com.sukrit.parkinglotsystem.models.ParkingLot;
import com.sukrit.parkinglotsystem.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {

  @Autowired
  private ParkingLotRepository parkingLotRepository;

  public ParkingLotDTO addParkingLot(ParkingLotDTO parkingLotDTO) {
    ParkingLot parkingLot = ParkingLot.builder()
        .parkingLotStatus(parkingLotDTO.getParkingLotStatus())
        .parkingAddress(parkingLotDTO.getParkingAddress())
        .parkingFloorList(parkingLotDTO.getParkingFloorList())
        .gst(parkingLotDTO.getGst())
        .name(parkingLotDTO.getName())
        .city(parkingLotDTO.getCity())
        .gates(parkingLotDTO.getGates())
        .build();
    parkingLot = this.parkingLotRepository.save(parkingLot);
    parkingLot.setId(parkingLot.getId());
    return parkingLotDTO;
  }
}
