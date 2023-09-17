package com.sukrit.parkinglotsystem.controllers;


import com.sukrit.parkinglotsystem.dto.VehicleDTO;
import com.sukrit.parkinglotsystem.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

  private VehicleService vehicleService;

  @PostMapping("/registerDetail")
  public ResponseEntity<VehicleDTO> register(@RequestBody VehicleDTO vehicleDTO){
    return ResponseEntity.ok(vehicleService.registerVehicle(vehicleDTO));
  }

  @GetMapping("/getDetails")
  public ResponseEntity<VehicleDTO> getDetails(@RequestBody String regNo){
    return ResponseEntity.ok(vehicleService.getDetails(regNo));
  }

  @PutMapping("/updateDetails")
  public ResponseEntity<VehicleDTO> updateVehicleDetails(@RequestBody VehicleDTO vehicleDTO){
    return ResponseEntity.ok(vehicleService.updateVehicle(vehicleDTO));
  }

  @DeleteMapping("/deregister")
  public ResponseEntity<String> unregister(@RequestBody VehicleDTO vehicleDTO){
    return ResponseEntity.ok(vehicleService.delete(vehicleDTO));
  }


}
