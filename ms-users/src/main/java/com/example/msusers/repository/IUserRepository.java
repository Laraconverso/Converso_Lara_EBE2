package com.example.msusers.repository;

import com.example.msusers.domain.User;

import java.util.List;

public interface IUserRepository {
    User findUserById(String id);

    List<User> getAllUsers();
}
