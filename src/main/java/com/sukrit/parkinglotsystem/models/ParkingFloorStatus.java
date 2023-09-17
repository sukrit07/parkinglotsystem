package com.sukrit.parkinglotsystem.models;

public enum ParkingFloorStatus {
  OPEN("Open"),
  CLOSED("Closed");

  public final String status;
  ParkingFloorStatus(String status) {
    this.status = status;
  }
}
