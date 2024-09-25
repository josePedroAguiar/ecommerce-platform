package com.example.userservice.adapters.driven.mongodb;


import com.example.userservice.application.ports.UserRepository;
import com.example.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoUserRepository implements UserRepository {

    @Autowired
    private MongoUserMongoRepository mongoRepository;

    @Override
    public List<User> findAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return mongoRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return mongoRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        mongoRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return mongoRepository.findByEmail(email);
    }
}
