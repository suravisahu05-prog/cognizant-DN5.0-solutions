package com.cognizant.orderservice.controller;

import com.cognizant.orderservice.client.UserClient;
import com.cognizant.orderservice.dto.UserDto;
import com.cognizant.orderservice.entity.Order;
import com.cognizant.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // Demonstrates inter-service communication via OpenFeign
    @GetMapping("/{id}/with-user")
    public Map<String, Object> getOrderWithUser(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        UserDto user = userClient.getUserById(order.getUserId());
        return Map.of("order", order, "user", user);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}
