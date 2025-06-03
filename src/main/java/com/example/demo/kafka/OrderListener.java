package com.example.demo.kafka;



import com.example.demo.dto.OrderDTO;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class OrderListener {

    private final OrderMapper orderMapper;
    private final OrderService orderService;

    public OrderListener(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }


    @KafkaListener(topics = "realtime_orders", groupId = "order-group")
    public void listen(OrderDTO dto) {
        Order order = orderMapper.toEntity(dto);
        orderService.saveOrder(order);
        System.out.println("Order saved: " + order);
    }
}
