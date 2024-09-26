package com.example.orderservice.adapters.driven.mongodb;

import com.example.orderservice.application.port.OrderRepository;
import com.example.orderservice.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MongoOrderRepositoryAdapter implements OrderRepository {

    @Autowired
    private MongoOrderRepository mongoOrderRepository;

    @Override
    public List<Order> findAll() {
        return mongoOrderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(String id) {
        return mongoOrderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return mongoOrderRepository.save(order);
    }

    @Override
    public void deleteById(String id) {
        mongoOrderRepository.deleteById(id);
    }

    @Override
    public List<Order> findByUserId(String userId) {
        return mongoOrderRepository.findByUserId(userId);
    }
}
