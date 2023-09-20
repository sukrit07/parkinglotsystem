package com.sukrit.parkinglotsystem.controllers;


import com.sukrit.parkinglotsystem.dto.ParkingLotDTO;
import com.sukrit.parkinglotsystem.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {

  @Autowired
  private ParkingLotService parkingLotService;

  @PostMapping("/add")
  public ResponseEntity<ParkingLotDTO> addParkingLot(@RequestBody ParkingLotDTO parkingLotDTO) {
    return ResponseEntity.ok(parkingLotService.addParkingLot(parkingLotDTO));
  }

}
