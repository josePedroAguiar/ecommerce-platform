package application.services;

import domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> findAll();
    Optional<Order> findById(String id);
    Order save(Order order);
    void deleteById(String id);
    List<Order> findByUserId(String userId);
}

