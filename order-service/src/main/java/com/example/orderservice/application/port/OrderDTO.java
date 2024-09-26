package com.example.orderservice.application.port;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrderDTO {

    @NotBlank(message = "Order ID is required")
    private String id;

    @NotBlank(message = "User ID is required")
    private String userId;

    @NotNull(message = "Product IDs cannot be null")
    private List<String> productIds;

    @Positive(message = "Total price must be positive")
    private Double totalPrice;

    private Optional orderStatus;

    @NotNull(message = "Order date is required")
    private Date orderDate;

    // Enum for order status
    public enum OrderStatus {
        PENDING,
        COMPLETED,
        CANCELED
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Optional getOrderStatus() {
        return orderStatus;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderStatus(Optional orderStatus) {
        this.orderStatus = orderStatus;
    }



    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }



}

