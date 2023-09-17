package com.sukrit.parkinglotsystem.service;

import com.sukrit.parkinglotsystem.builders.TicketEntityDTOBuilder;
import com.sukrit.parkinglotsystem.builders.UserEntityDTOBuilder;
import com.sukrit.parkinglotsystem.builders.VehicleEntityDTOBuilder;
import com.sukrit.parkinglotsystem.dto.EntryDTO;
import com.sukrit.parkinglotsystem.dto.TicketDTO;
import com.sukrit.parkinglotsystem.exceptions.InvalidDataException;
import com.sukrit.parkinglotsystem.exceptions.ParkingLotFullException;
import com.sukrit.parkinglotsystem.models.ParkingFloor;
import com.sukrit.parkinglotsystem.models.ParkingFloorStatus;
import com.sukrit.parkinglotsystem.models.ParkingSpot;
import com.sukrit.parkinglotsystem.models.ParkingSpotStatus;
import com.sukrit.parkinglotsystem.models.Ticket;
import com.sukrit.parkinglotsystem.models.TicketStatus;
import com.sukrit.parkinglotsystem.models.User;
import com.sukrit.parkinglotsystem.models.Vehicle;
import com.sukrit.parkinglotsystem.repository.ParkingFloorRepository;
import com.sukrit.parkinglotsystem.repository.ParkingSpotRepository;
import com.sukrit.parkinglotsystem.repository.TicketRepository;
import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

  @Autowired
  private UserService userService;

  @Autowired
  private VehicleService vehicleService;

  @Autowired
  private ParkingFloorRepository parkingFloorRepository;

  @Autowired
  private ParkingSpotRepository parkingSpotRepository;

  @Autowired
  private TicketRepository ticketRepository;


  public TicketDTO generateEntry(EntryDTO entryDTO){

    //Find User Details
    User user =
        UserEntityDTOBuilder.toEntity(this.userService.getUserDetailsByMobile(entryDTO.getMobileNumber()));

    //Find Vehicle Details
    Vehicle vehicle =
        VehicleEntityDTOBuilder.toEntity(this.vehicleService.getDetails(entryDTO.getVehicleRegistrationNumber()));

    //Find Operator Details
    User entryOperator =
        UserEntityDTOBuilder.toEntity(this.userService.getUserDetails(entryDTO.getOperatorId()));

    ParkingFloor parkingFloor = this.parkingFloorRepository.findFirstByParkingFloorStatus(
        ParkingFloorStatus.OPEN);

    if(parkingFloor == null){
      throw new ParkingLotFullException("Parking Lot Full");
    }

    ParkingSpot parkingSpot =
        this.parkingSpotRepository.findFirstByParkingFloorAndParkingSpotStatus(parkingFloor, ParkingSpotStatus.OPEN);

    if(parkingSpot==null){
      throw new ParkingLotFullException("Parking Lot Full");
    }

    parkingSpot.setParkingSpotStatus(ParkingSpotStatus.CLOSED);
    this.parkingSpotRepository.save(parkingSpot);

    Ticket ticket = Ticket.builder()
        .startTime(entryDTO.getEntryTime()!=null?entryDTO.getEntryTime(): Date.from(Instant.now()))
        .user(user)
        .vehicle(vehicle)
        .parkingSpot(parkingSpot)
        .ticketStatus(TicketStatus.OPEN)
        .entryGateOperator(entryOperator).build();



    this.ticketRepository.save(ticket);
    return TicketEntityDTOBuilder.toDto(ticket);
  }
}
