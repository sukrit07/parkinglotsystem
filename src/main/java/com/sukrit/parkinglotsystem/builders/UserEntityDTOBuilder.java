package com.sukrit.parkinglotsystem.builders;

import com.sukrit.parkinglotsystem.dto.UserDTO;
import com.sukrit.parkinglotsystem.models.ParkingLotUser;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEntityDTOBuilder {

  public UserDTO toDto(ParkingLotUser user){
    return UserDTO.builder()
        .name(user.getName())
        .mobileNo(user.getMobileNo())
        .mailId(user.getMailId())
        .userType(user.getUserType())
        .build();
  }
  public ParkingLotUser toEntity(UserDTO userDTO){
    return ParkingLotUser.builder()
        .name(userDTO.getName())
        .mobileNo(userDTO.getMobileNo())
        .mailId(userDTO.getMailId())
        .userType(userDTO.getUserType())
        .password(userDTO.getPassword())
        .build();
  }

}
