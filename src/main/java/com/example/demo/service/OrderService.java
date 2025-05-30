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

    }

    public List<Order> getOrdersByType(String type) {
        return orderRepository.findByType(type);

    }

    public List<Order> getRecentOrder() {
        return orderRepository.findAll();

    }

    public void processLatestOrder() {
        Order latest = orderRepository.findTopByOrderByTimestampDesc();
        if (latest != null) {
            orderMetrics.updateTemperature(latest.getOrders());
        }
    }
}
