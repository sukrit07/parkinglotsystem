package com.sukrit.parkinglotsystem.service;


import com.sukrit.parkinglotsystem.builders.UserEntityDTOBuilder;
import com.sukrit.parkinglotsystem.dto.UserDTO;
import com.sukrit.parkinglotsystem.exceptions.DataNotFoundException;
import com.sukrit.parkinglotsystem.exceptions.DuplicateRecordException;
import com.sukrit.parkinglotsystem.exceptions.InvalidDataException;
import com.sukrit.parkinglotsystem.models.ParkingLotUser;
import com.sukrit.parkinglotsystem.repository.UserRepository;
import com.sukrit.parkinglotsystem.utility.EncrypterPassword;
import com.sukrit.parkinglotsystem.utility.UserValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public UserDTO registerUser(UserDTO userDTO){

      if(!UserValidator.validateUserDetails(userDTO))
        throw new InvalidDataException("Invalid User Input");

      if(userRepository.findByMobileNo(userDTO.getMobileNo()).isPresent())
        throw new DuplicateRecordException("User already present in database");


      ParkingLotUser user = UserEntityDTOBuilder.toEntity(userDTO);
      user.setPassword(EncrypterPassword.generateEncrypted(userDTO.getPassword()));
      user = this.userRepository.save(user);

      return UserEntityDTOBuilder.toDto(user);
  }

  public UserDTO updateUser(UserDTO userDTO){

    if(!UserValidator.validateUserDetails(userDTO))
      throw new InvalidDataException("Invalid User Input");

    if(userRepository.findByMobileNo(userDTO.getMobileNo()).isEmpty())
      throw new DataNotFoundException("User does not present");

    ParkingLotUser user = userRepository.findByMobileNo(userDTO.getMobileNo()).get();
    ParkingLotUser userEdit =  UserEntityDTOBuilder.toEntity(userDTO);
    userEdit.setId(user.getId());
    userEdit.setPassword(user.getPassword());

    user = this.userRepository.save(userEdit);

    return UserEntityDTOBuilder.toDto(userEdit);
  }

  public String deleteUser(UserDTO userDTO){

    if(!UserValidator.validateUserDetails(userDTO))
      throw new InvalidDataException("Invalid User Input");

    if(userRepository.findByMobileNo(userDTO.getMobileNo()).isEmpty())
      throw new  DataNotFoundException("User not present in database");

    ParkingLotUser user = UserEntityDTOBuilder.toEntity(userDTO);
    this.userRepository.delete(user);

    return "User Delete done";
  }

  public  UserDTO getUserDetails(Long userId){
    if (this.userRepository.findById(userId).isEmpty())
      throw new DataNotFoundException("User does not present");
    ParkingLotUser user = this.userRepository.findById(userId).get();
    return UserEntityDTOBuilder.toDto(user);
  }

  public UserDTO getUserDetailsByMobile(String mobile){
    if (this.userRepository.findByMobileNo(mobile).isEmpty())
      throw new DataNotFoundException("User does not present");
    ParkingLotUser user = this.userRepository.findByMobileNo(mobile).get();
    return UserEntityDTOBuilder.toDto(user);
  }

}
