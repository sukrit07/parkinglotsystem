package com.sukrit.parkinglotsystem.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot extends BaseModel {

  private String name;
  private String gst;
  private String parkingAddress;

  @ManyToOne
  private City city;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Gate> gates;

  @Enumerated(EnumType.ORDINAL)
  private ParkingLotStatus parkingLotStatus;

  @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
  private List<ParkingFloor> parkingFloorList;
}

