package com.example.userservice.application.ports;
import com.example.userservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(String id);
    User save(User user);
    void deleteById(String id);
    Optional<User> findByEmail(String email);
}
