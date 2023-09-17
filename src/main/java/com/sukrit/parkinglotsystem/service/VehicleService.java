package com.sukrit.parkinglotsystem.service;

import com.sukrit.parkinglotsystem.builders.VehicleEntityDTOBuilder;
import com.sukrit.parkinglotsystem.dto.VehicleDTO;
import com.sukrit.parkinglotsystem.exceptions.DataNotFoundException;
import com.sukrit.parkinglotsystem.exceptions.InvalidDataException;
import com.sukrit.parkinglotsystem.models.Vehicle;
import com.sukrit.parkinglotsystem.repository.VehicleRepository;
import com.sukrit.parkinglotsystem.utility.VehicleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleService {

  @Autowired
  private VehicleRepository vehicleRepository;


  public VehicleDTO registerVehicle(VehicleDTO vehicleDTO){

    //Validate Vehicle Details
    if(!VehicleValidator.validateVehicleDetails(vehicleDTO)){
      throw new InvalidDataException("Invalid Vehicle Details provided");
    }

    //Check whether record exists
    if(vehicleRepository.findByRegistrationNo(vehicleDTO.getRegistrationNo())!=null){
      throw new DataNotFoundException("Vehicle data exists in our db");
    }

    //Convert to Vehicle
    Vehicle vehicle = VehicleEntityDTOBuilder.toEntity(vehicleDTO);
    vehicle = this.vehicleRepository.save(vehicle);
    return VehicleEntityDTOBuilder.toDto(vehicle);
  }

  public VehicleDTO getDetails(String regNo){
    if(!VehicleValidator.validateVehicleRegistrationNumber(regNo)){
      throw new InvalidDataException("Invalid Vehicle Details provided");
    }

    //Check whether record exists
    if(vehicleRepository.findByRegistrationNo(regNo)!=null){
      throw new DataNotFoundException("Vehicle Not Found. Please register");
    }

    //Convert to Vehicle
    Vehicle vehicle = this.vehicleRepository.findByRegistrationNo(regNo);
    return VehicleEntityDTOBuilder.toDto(vehicle);
  }

  public VehicleDTO updateVehicle(VehicleDTO vehicleDTO)  {
    //Validate Vehicle Details
    if(!VehicleValidator.validateVehicleDetails(vehicleDTO)){
      throw new InvalidDataException("Invalid Vehicle Details provided");
    }

    //Check whether record exists
    if(vehicleRepository.findByRegistrationNo(vehicleDTO.getRegistrationNo())==null){
      throw new DataNotFoundException("Vehicle Not Found. First register.");
    }

    //Convert to Vehicle
    Vehicle vehicle = VehicleEntityDTOBuilder.toEntity(vehicleDTO);
    vehicle = this.vehicleRepository.save(vehicle);
    return VehicleEntityDTOBuilder.toDto(vehicle);
  }

  public String delete(VehicleDTO vehicleDTO) {

    //Validate Vehicle Details
    if(!VehicleValidator.validateVehicleDetails(vehicleDTO)){
      throw new InvalidDataException("Invalid Vehicle Details provided");
    }

    //Check whether record exists
    if(vehicleRepository.findByRegistrationNo(vehicleDTO.getRegistrationNo())!=null){
      throw new DataNotFoundException("Vehicle not found");
    }

    vehicleRepository.delete(VehicleEntityDTOBuilder.toEntity(vehicleDTO));
    vehicleRepository.flush();
    return "Deleted Vehicle Detail";
  }

}
