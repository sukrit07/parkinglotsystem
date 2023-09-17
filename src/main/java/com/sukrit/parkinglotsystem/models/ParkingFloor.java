package com.sukrit.parkinglotsystem.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class ParkingFloor extends BaseModel{
    private int floorNo;

    @Enumerated
    private ParkingFloorStatus parkingFloorStatus;

    @OneToMany(mappedBy = "parkingFloor", cascade = CascadeType.ALL)
    private List<ParkingSpot> parkingSpotsList;

    @ManyToOne
    private ParkingLot parkingLot;
}
