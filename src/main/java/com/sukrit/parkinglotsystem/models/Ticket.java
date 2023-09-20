package com.sukrit.parkinglotsystem.models;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseModel{

  @OneToOne
  private Vehicle vehicle;

  @OneToOne
  private ParkingLotUser entryGateOperator;

  @OneToOne
  private ParkingLotUser exitGateOperator;

  @ManyToOne
  private ParkingLotUser user;

  private Date startTime;
  private Date endTime;
  private Double amount;

  @Enumerated(EnumType.ORDINAL)
  @ElementCollection
  private List<PaymentMethod> paymentMethodList;

  @Enumerated(EnumType.ORDINAL)
  private TicketStatus ticketStatus;

  @OneToOne
  private ParkingSpot parkingSpot;

}
