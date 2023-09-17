package com.sukrit.parkinglotsystem.exceptions;


import lombok.Getter;

@Getter
public class ParkingLotFullException extends RuntimeException{

  private final String message;

  public ParkingLotFullException(String message){
    super(message);
    this.message = message;
  }

}
