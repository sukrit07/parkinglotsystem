package com.sukrit.parkinglotsystem.service;

import com.sukrit.parkinglotsystem.builders.TicketEntityDTOBuilder;
import com.sukrit.parkinglotsystem.builders.UserEntityDTOBuilder;
import com.sukrit.parkinglotsystem.builders.VehicleEntityDTOBuilder;
import com.sukrit.parkinglotsystem.dto.EntryDTO;
import com.sukrit.parkinglotsystem.dto.ExitDTO;
import com.sukrit.parkinglotsystem.dto.TicketDTO;
import com.sukrit.parkinglotsystem.exceptions.InvalidDataException;
import com.sukrit.parkinglotsystem.exceptions.ParkingLotFullException;
import com.sukrit.parkinglotsystem.models.ParkingFloor;
import com.sukrit.parkinglotsystem.models.ParkingFloorStatus;
import com.sukrit.parkinglotsystem.models.ParkingSpot;
import com.sukrit.parkinglotsystem.models.ParkingSpotStatus;
import com.sukrit.parkinglotsystem.models.Ticket;
import com.sukrit.parkinglotsystem.models.TicketStatus;
import com.sukrit.parkinglotsystem.models.ParkingLotUser;
import com.sukrit.parkinglotsystem.models.Vehicle;
import com.sukrit.parkinglotsystem.repository.ParkingFloorRepository;
import com.sukrit.parkinglotsystem.repository.ParkingSpotRepository;
import com.sukrit.parkinglotsystem.repository.TicketRepository;
import java.time.Instant;
import java.util.Date;
import java.util.List;
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


  public TicketDTO generateEntry(EntryDTO entryDTO) {

    //Find User Details
    ParkingLotUser user =
        UserEntityDTOBuilder.toEntity(
            this.userService.getUserDetailsByMobile(entryDTO.getMobileNumber()));

    //Find Vehicle Details
    Vehicle vehicle =
        VehicleEntityDTOBuilder.toEntity(
            this.vehicleService.getDetails(entryDTO.getVehicleRegistrationNumber()));

    //Find Operator Details
    ParkingLotUser entryOperator =
        UserEntityDTOBuilder.toEntity(this.userService.getUserDetails(entryDTO.getOperatorId()));

    List<ParkingFloor> parkingFloorList =
        this.parkingFloorRepository.findParkingFloorByParkingFloorStatus(
            ParkingFloorStatus.OPEN);

    if (parkingFloorList.isEmpty()) {
      throw new ParkingLotFullException("Parking Lot Full");
    }

    for (ParkingFloor parkingFloor : parkingFloorList) {
      ParkingSpot parkingSpot =
          this.parkingSpotRepository.findFirstByParkingFloorAndParkingSpotStatus(parkingFloor,
              ParkingSpotStatus.AVAILABLE);

      if (parkingSpot != null) {
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.NOT_AVAILABLE);
        this.parkingSpotRepository.save(parkingSpot);
      }

      Ticket ticket = Ticket.builder()
          .startTime(
              entryDTO.getEntryTime() != null ? entryDTO.getEntryTime() : Date.from(Instant.now()))
          .user(user)
          .vehicle(vehicle)
          .parkingSpot(parkingSpot)
          .ticketStatus(TicketStatus.OPEN)
          .entryGateOperator(entryOperator)
          .build();

      ticket = this.ticketRepository.save(ticket);
      return TicketEntityDTOBuilder.toDto(ticket);
    }

    throw new ParkingLotFullException("Parking Lot Full");

  }

  public TicketDTO ẻmptyParkingSlot(ExitDTO exitDTO) {

    if(this.ticketRepository.findById(exitDTO.getTicketId()).isEmpty())
      throw new InvalidDataException("Invalid Ticket");

    Ticket ticket = this.ticketRepository.findById(exitDTO.getTicketId()).get();

    //Find Operator Details
    ParkingLotUser exitOperator =
        UserEntityDTOBuilder.toEntity(this.userService.getUserDetails(exitDTO.getExitOperatorId()));

    ticket.setExitGateOperator(exitOperator);
    calculateParkingCharges(ticket);
    ticketRepository.save(ticket);

    ParkingSpot parkingSpot = ticket.getParkingSpot();
    parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
    this.parkingSpotRepository.save(parkingSpot);
    return TicketEntityDTOBuilder.toDto(ticket);

  }
  public void calculateParkingCharges(Ticket ticket){
    double amount = 100.0;
    Date entryTime = ticket.getStartTime();
    Date exitTime = Date.from(Instant.now());

    long time_difference = exitTime.getTime() - entryTime.getTime();
    long hours = (time_difference / (1000*60*60)) % 24;

    amount = amount + (hours*50);
    ticket.setAmount(amount);
  }
}
