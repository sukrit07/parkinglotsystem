package com.sukrit.parkinglotsystem.utility;

import com.sukrit.parkinglotsystem.dto.VehicleDTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;


@UtilityClass
public class VehicleValidator {

  public Boolean validateVehicleDetails(VehicleDTO vehicleDTO){
    return (validateVehicleRegistrationNumber(vehicleDTO.getRegistrationNo()) && validateVehicleManufacturer(vehicleDTO));
  }

  public Boolean validateVehicleRegistrationNumber(String registrationNum){
    String patterns = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$";
    Pattern pattern = Pattern.compile(patterns);
    Matcher matcher = pattern.matcher(registrationNum);
    return matcher.matches();
  }

  public Boolean validateVehicleManufacturer(VehicleDTO vehicleDTO){
    return vehicleDTO.getManufacturer() != null;
  }

}
