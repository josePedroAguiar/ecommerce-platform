package adapters.rest;

import application.services.OrderRepository;
import domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);

        // Add order to user's order history in the UserService
        String userServiceUrl = "http://localhost:8081/users/" + savedOrder.getUserId() + "/add-order?orderId=" + savedOrder.getId();
        restTemplate.postForObject(userServiceUrl, null, Void.class);

        return savedOrder;
    }
}
