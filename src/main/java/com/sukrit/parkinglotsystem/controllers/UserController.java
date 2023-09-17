package com.sukrit.parkinglotsystem.controllers;


import com.sukrit.parkinglotsystem.dto.UserDTO;
import com.sukrit.parkinglotsystem.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
    return ResponseEntity.ok(userService.registerUser(userDTO));
  }

  @PutMapping("/edit")
  public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO){
    return ResponseEntity.ok(userService.updateUser(userDTO));
  }

  @GetMapping("/getDetails/{userId}")
  public ResponseEntity<UserDTO> getDetailsOfUser(@PathVariable Long userId){
    return ResponseEntity.ok(userService.getUserDetails(userId));
  }

  @PostMapping("/delete")
  public ResponseEntity<String> remove(@RequestBody UserDTO userDTO){
    return ResponseEntity.ok(userService.deleteUser(userDTO));
  }

}
