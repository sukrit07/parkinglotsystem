package com.sukrit.parkinglotsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel{

  private String name;

  @Id//@Column(unique = true)
  private String mobileNo;
  private String mailId;
  private String password;

  @Enumerated(EnumType.ORDINAL)
  private UserType userType;

}
