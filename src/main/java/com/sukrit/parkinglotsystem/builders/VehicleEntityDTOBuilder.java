package com.sukrit.parkinglotsystem.builders;

import com.sukrit.parkinglotsystem.dto.VehicleDTO;
import com.sukrit.parkinglotsystem.models.Vehicle;
import lombok.experimental.UtilityClass;


@UtilityClass
public class VehicleEntityDTOBuilder {

  public Vehicle toEntity(VehicleDTO vehicleDTO){
    return Vehicle.builder()
        .registrationNo(vehicleDTO.getRegistrationNo())
        .manufacturer(vehicleDTO.getManufacturer())
        .color(vehicleDTO.getColor()).build();
  }

  public VehicleDTO toDto(Vehicle vehicle){
    return VehicleDTO.builder()
        .registrationNo(vehicle.getRegistrationNo())
        .manufacturer(vehicle.getManufacturer())
        .color(vehicle.getColor()).build();
  }

}
