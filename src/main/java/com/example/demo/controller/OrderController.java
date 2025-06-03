package com.example.demo.controller;


import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    public OrderController(OrderRepository orderRepository) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getRecentOrders();
    }

    @GetMapping("/product/{productName}")
    public List<Order> getOrdersByProduct(@PathVariable String productName) {
        return orderService.getOrdersByProduct(productName);
    }

    @GetMapping("/latest")
    public Order getLatestOrder() {
        return orderService.getLatestOrder();
    }
}
