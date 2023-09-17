package com.sukrit.parkinglotsystem.dto;

import com.sukrit.parkinglotsystem.models.PaymentMethod;
import com.sukrit.parkinglotsystem.models.Vehicle;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

  private VehicleDTO vehicleDTO;
  private UserDTO userDTO;
  private Date startTime;
  private Date endTime;
  private Double amount;
  private PaymentMethod paymentMethod;

}
