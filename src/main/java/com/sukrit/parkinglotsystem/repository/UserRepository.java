package com.sukrit.parkinglotsystem.repository;


import com.sukrit.parkinglotsystem.models.ParkingLotUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ParkingLotUser, Long> {
    Optional<ParkingLotUser> findByMobileNo(String mobileNo);
}
