package com.example.msusers.controller;

import com.example.msusers.domain.User;
import com.example.msusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/userId/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findUserById(id));
    }

    @GetMapping("/{userId}/bills")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getBillsByUserId (@PathVariable String id) {
        return ResponseEntity.ok().body(service.getUserWithBillsById(id));
    }

    @GetMapping("/allBills")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> allBills() {
        return ResponseEntity.ok().body(service.findAllBills());
    }



}
