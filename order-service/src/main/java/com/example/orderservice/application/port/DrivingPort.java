package com.example.orderservice.application.port;

import com.example.orderservice.domain.Order;
import java.util.List;
import java.util.Optional;

public interface DrivingPort {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(String id);
    List<Order> getOrdersByUserId(String userId);
    Order createOrder(Order order);
    Order updateOrderStatus(String id, Order.OrderStatus status);
    void deleteOrder(String id);
}
