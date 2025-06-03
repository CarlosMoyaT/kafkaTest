package com.example.demo.service;

import com.example.demo.metrics.OrderMetrics;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private final OrderMetrics orderMetrics;

    public OrderService(OrderRepository orderRespository, OrderMetrics orderMetrics) {
        this.orderRepository = orderRespository;
        this.orderMetrics = orderMetrics;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
        orderMetrics.trackOrder(order.getPrice(), order.getProductName());

    }

    public List<Order> getOrdersByProduct(String productName) {
        return orderRepository.findByProductName(productName);
    }

    public Order getLatestOrder() {
        return orderRepository.findTopByOrderByTimestampDesc();
    }

    public List<Order> getRecentOrders() {
        return orderRepository.findAll();
    }



}
