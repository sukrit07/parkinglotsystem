package com.sukrit.parkinglotsystem.exceptions;


import lombok.Getter;

@Getter
public class DependencyException extends RuntimeException{

  private final String message;

  public DependencyException(String message){
    super(message);
    this.message = message;
  }

}
