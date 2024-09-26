package com.example.orderservice.adapters.driving.rest;
import com.example.orderservice.application.port.OrderDTO;
import com.example.orderservice.application.port.DrivingPort;

import com.example.orderservice.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private DrivingPort orderService;

    private OrderDTO mapToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setProductIds(order.getProductIds());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setOrderDate(order.getOrderDate());
        return dto;
    }

    // Mapper Method to convert OrderDTO to Order
    private Order mapToEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setUserId(dto.getUserId());
        order.setProductIds(dto.getProductIds());
        order.setTotalPrice(dto.getTotalPrice());
        order.setOrderStatus(dto.getOrderStatus());
        order.setOrderDate(dto.getOrderDate());
        return order;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        // Convert Order List to OrderDTO List
        return orderService.getAllOrders().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<OrderDTO> getOrderById(@PathVariable String id) {
        // Convert Optional<Order> to Optional<OrderDTO>
        return orderService.getOrderById(id)
                .map(this::mapToDTO);
    }

    @GetMapping("/user/{userId}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable String userId) {
        return orderService.getOrdersByUserId(userId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public OrderDTO createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        // Convert DTO to Entity, then back to DTO after saving
        Order order = mapToEntity(orderDTO);
        Order savedOrder = orderService.createOrder(order);
        return mapToDTO(savedOrder);
    }

    @PutMapping("/{id}/status")
    public OrderDTO updateOrderStatus(@PathVariable String id, @RequestParam Order.OrderStatus status) {
        // Find and update the status of the order
        Order updatedOrder = orderService.updateOrderStatus(id, status);
        return mapToDTO(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
    }
}

