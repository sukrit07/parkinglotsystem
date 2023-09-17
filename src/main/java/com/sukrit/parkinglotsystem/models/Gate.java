package com.sukrit.parkinglotsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Gate extends BaseModel{

  private String gateNo;

  @Enumerated(EnumType.ORDINAL)
  private GateType gateType;

}
