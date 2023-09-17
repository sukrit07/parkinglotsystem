package com.sukrit.parkinglotsystem.exceptions;


import lombok.Getter;

@Getter
public class DataNotFoundException extends RuntimeException{

  private final String message;

  public DataNotFoundException(String message){
    super(message);
    this.message = message;
  }
}
