package com.sukrit.parkinglotsystem.repository;

import com.sukrit.parkinglotsystem.models.Ticket;
import com.sukrit.parkinglotsystem.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

  public Ticket findByVehicle(Vehicle vehicleToSearchFor);

}
