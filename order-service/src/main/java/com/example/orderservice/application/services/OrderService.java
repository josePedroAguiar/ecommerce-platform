package com.example.orderservice.application.services;
import com.example.orderservice.application.port.OrderRepository;
import com.example.orderservice.application.port.DrivingPort;
import com.example.orderservice.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements DrivingPort {

    @Autowired
    private OrderRepository orderRepository;


    private RestTemplate restTemplate;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }


    public Order updateOrderStatus(String orderId, Order.OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }

    public Order createOrder(Order order) {
        order.setOrderStatus(Order.OrderStatus.PENDING);
        Order savedOrder = orderRepository.save(order);

        // Add order to user's order history in the UserService
        String userServiceUrl = "http://localhost:8081/users/" + savedOrder.getUserId() + "/add-order?orderId=" + savedOrder.getId();
        restTemplate.postForObject(userServiceUrl, null, Void.class);
        return savedOrder;

    }
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
