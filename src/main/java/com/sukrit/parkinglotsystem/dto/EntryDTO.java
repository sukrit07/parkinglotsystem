package com.sukrit.parkinglotsystem.dto;


import java.util.Date;
import lombok.Data;

@Data
public class EntryDTO {
  private String vehicleRegistrationNumber;
  private Date entryTime;
  private String mobileNumber;
  private Long operatorId;
}
