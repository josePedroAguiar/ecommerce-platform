package domain;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private String id;
    private String userId;
    private List<String> productIds;
    private Double totalPrice;
    private OrderStatus orderStatus;
    private Date orderDate;

    // Enum for order status
    public enum OrderStatus {
        PENDING,
        COMPLETED,
        CANCELED
    }

}
