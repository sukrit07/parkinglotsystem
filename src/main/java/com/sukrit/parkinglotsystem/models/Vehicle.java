package com.sukrit.parkinglotsystem.models;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends BaseModel{
  private String registrationNo;
  private String manufacturer;
  private String color;
}
