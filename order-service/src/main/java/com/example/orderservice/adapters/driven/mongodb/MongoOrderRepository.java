package com.example.orderservice.adapters.driven.mongodb;


import com.example.orderservice.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MongoOrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);
}
