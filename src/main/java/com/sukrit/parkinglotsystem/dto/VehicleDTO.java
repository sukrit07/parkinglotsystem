package com.sukrit.parkinglotsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

  private String registrationNo;
  private String manufacturer;
  private String color;

}
