package com.example.userservice.application.service;

import com.example.userservice.application.ports.UserRepository;
import com.example.userservice.domain.User;
import com.example.userservice.domain.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        user.setWallet(new Wallet());
        user.getWallet().setBalance(0);
        return userRepository.save(user);
    }

    public User updateUser(String id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User addFunds(String userId, int amount) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.getWallet().setBalance(user.getWallet().getBalance() + amount);
        return userRepository.save(user);
    }

    public void addOrderToHistory(String userId, String orderId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.getOrderHistory().add(orderId);
        userRepository.save(user);
    }
}
