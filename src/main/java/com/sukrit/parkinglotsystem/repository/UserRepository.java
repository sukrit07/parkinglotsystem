package com.sukrit.parkinglotsystem.repository;


import com.sukrit.parkinglotsystem.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMobileNo(String mobileNo);
}
