package com.sukrit.parkinglotsystem.dto;

import com.sukrit.parkinglotsystem.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  private String name;
  private String mobileNo;
  private String mailId;
  private UserType userType;
  private String password;

}
