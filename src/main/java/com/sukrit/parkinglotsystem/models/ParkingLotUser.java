package com.sukrit.parkinglotsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLotUser extends BaseModel{

  private String name;

  @Column(unique = true)
  private String mobileNo;
  private String mailId;
  private String password;

  @Enumerated(EnumType.STRING)
  private UserType userType;

}
