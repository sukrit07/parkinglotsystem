package com.sukrit.parkinglotsystem.utility;


import com.sukrit.parkinglotsystem.dto.UserDTO;
import com.sukrit.parkinglotsystem.dto.VehicleDTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserValidator {

  public Boolean validateUserDetails(UserDTO userDTO){
    return (validateUserName(userDTO.getName()) &&
        validateMobileNumber(userDTO.getMobileNo()) &&
        validateEmail(userDTO.getMailId()));
  }

  public Boolean validateMobileNumber(String mobileNumber){
    String patterns
        = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
        + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
        + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
    Pattern pattern = Pattern.compile(patterns);
    Matcher matcher = pattern.matcher(mobileNumber);
    return matcher.matches();
  }

  public Boolean validateEmail(String email){
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

  public Boolean validateUserName(String name){
    String regex = "^[A-Za-z]+$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(name);
    return matcher.matches();
  }
}
