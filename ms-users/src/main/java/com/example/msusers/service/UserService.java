package com.example.msusers.service;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import com.example.msusers.domain.dto.UsersBills;
import com.example.msusers.repository.FeignBillRepository;
import com.example.msusers.repository.IUserRepository;
import com.example.msusers.repository.KeycloakUserRepository;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private IUserRepository userRepository;
    private FeignBillRepository billRepository;

    public List<User> findAll() {
        return userRepository.getAllUsers();
    }

    public List<Bill> findAllBills(){
        return billRepository.getAll();
    }

    public User findUserById(String id){
        return userRepository.findUserById(id);
    }

    public UsersBills getUserWithBillsById(String id){
        User u = userRepository.findUserById(id);
        List<Bill> bills = this.billRepository.findByCustomerId(id);
        return new UsersBills(u, bills);
    }


}
