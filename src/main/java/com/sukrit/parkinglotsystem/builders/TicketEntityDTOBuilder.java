package com.sukrit.parkinglotsystem.builders;

import com.sukrit.parkinglotsystem.dto.TicketDTO;
import com.sukrit.parkinglotsystem.models.Ticket;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketEntityDTOBuilder {

  public TicketDTO toDto(Ticket ticket){
    return TicketDTO.builder()
        .vehicleDTO(VehicleEntityDTOBuilder.toDto(ticket.getVehicle()))
        .ticketId(ticket.getId())
        .startTime(ticket.getStartTime())
        .endTime(ticket.getEndTime())
        .amount(ticket.getAmount())
        .userDTO(UserEntityDTOBuilder.toDto(ticket.getUser()))
        .build();
  }
  public Ticket toEntity(TicketDTO ticketDTO){
    return Ticket.builder()
        .vehicle(VehicleEntityDTOBuilder.toEntity(ticketDTO.getVehicleDTO()))
        .startTime(ticketDTO.getStartTime())
        .endTime(ticketDTO.getEndTime())
        .amount(ticketDTO.getAmount())
        .user(UserEntityDTOBuilder.toEntity(ticketDTO.getUserDTO()))
        .build();
  }

}
