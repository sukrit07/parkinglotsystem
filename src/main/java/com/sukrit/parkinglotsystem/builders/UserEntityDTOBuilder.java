package com.sukrit.parkinglotsystem.builders;

import com.sukrit.parkinglotsystem.dto.UserDTO;
import com.sukrit.parkinglotsystem.models.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEntityDTOBuilder {

  public UserDTO toDto(User user){
    return UserDTO.builder()
        .name(user.getName())
        .mobileNo(user.getMobileNo())
        .mailId(user.getMailId())
        .userType(user.getUserType())
        .build();
  }
  public User toEntity(UserDTO userDTO){
    return User.builder()
        .name(userDTO.getName())
        .mobileNo(userDTO.getMobileNo())
        .mailId(userDTO.getMailId())
        .userType(userDTO.getUserType())
        .build();
  }

}
