package com.sukrit.parkinglotsystem.controllers;

import com.sukrit.parkinglotsystem.dto.EntryDTO;
import com.sukrit.parkinglotsystem.dto.ExitDTO;
import com.sukrit.parkinglotsystem.dto.TicketDTO;
import com.sukrit.parkinglotsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ticket")
@RestController
public class TicketController {

  @Autowired
  private TicketService ticketService;

  @PostMapping("/entry")
  public ResponseEntity<TicketDTO> bookParking(@RequestBody EntryDTO entry){
    return ResponseEntity.ok(ticketService.generateEntry(entry));
  }

  @PostMapping("/exit")
  public ResponseEntity<TicketDTO> emptyParking(@RequestBody ExitDTO exit){
    return ResponseEntity.ok(ticketService.ẻmptyParkingSlot(exit));
  }

}
