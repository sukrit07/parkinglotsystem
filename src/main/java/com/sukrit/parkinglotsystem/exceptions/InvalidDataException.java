package com.sukrit.parkinglotsystem.exceptions;


import lombok.Getter;

@Getter
public class InvalidDataException extends RuntimeException{

  private final String message;

  public InvalidDataException(String message){
    super(message);
    this.message = message;
  }
}
