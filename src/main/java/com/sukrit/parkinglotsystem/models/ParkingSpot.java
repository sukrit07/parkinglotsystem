package com.sukrit.parkinglotsystem.models;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class ParkingSpot extends BaseModel{

  private String spotName;

  @Enumerated(EnumType.STRING)
  private ParkingSpotStatus parkingSpotStatus;

  @Enumerated(EnumType.ORDINAL)
  @ElementCollection
  private List<VehicleType> supportedVehicleTypes;

  @ManyToOne
  private ParkingFloor parkingFloor;

}
