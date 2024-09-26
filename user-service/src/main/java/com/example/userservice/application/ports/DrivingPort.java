package com.example.userservice.application.ports;

import com.example.userservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface DrivingPort {
    List<User> getAllUsers();
    Optional<User> getUserById(String id);
    User createUser(User user);
    User updateUser(String id, User user);
    void deleteUserById(String id);
    Optional<User> getUserByEmail(String email);
    User addFunds(String userId, int amount);
    void addOrderToHistory(String userId, String orderId);
}
