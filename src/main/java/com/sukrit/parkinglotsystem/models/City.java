package com.sukrit.parkinglotsystem.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City extends BaseModel {
  private String name;

  private String state;

  @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
  private List<ParkingLot> parkingLotsList;
}