package com.sukrit.parkinglotsystem.repository;


import com.sukrit.parkinglotsystem.models.Vehicle;
import com.sukrit.parkinglotsystem.service.VehicleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  public Vehicle findByRegistrationNo(String regNo);

}
