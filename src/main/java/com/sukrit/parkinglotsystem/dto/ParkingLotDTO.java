package com.sukrit.parkinglotsystem.dto;

import com.sukrit.parkinglotsystem.models.City;
import com.sukrit.parkinglotsystem.models.Gate;
import com.sukrit.parkinglotsystem.models.ParkingFloor;
import com.sukrit.parkinglotsystem.models.ParkingLotStatus;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotDTO {

  private Long id;
  private String name;
  private String gst;
  private String parkingAddress;
  private City city;
  private List<Gate> gates;
  private ParkingLotStatus parkingLotStatus;
  private List<ParkingFloor> parkingFloorList;
}
