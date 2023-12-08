package com.example.msusers.domain.dto;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class UsersBills {

    private User user;
    private List<Bill> bills;
}