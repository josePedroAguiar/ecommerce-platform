package com.example.userservice.adapters.driven.mongodb;

import com.example.userservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoUserMongoRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}

