package com.example.orderservice.domain;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
public class Order {
    private String id;
    private String userId;
    private List<String> productIds;
    private Double totalPrice;
    private OrderStatus orderStatus;
    private Date orderDate;

    public void setOrderStatus(Optional orderStatus) {
    }

    // Enum for order status
    public enum OrderStatus {
        PENDING,
        COMPLETED,
        CANCELED
    }

    public Optional getOrderStatus() {
        return  Optional.of(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
