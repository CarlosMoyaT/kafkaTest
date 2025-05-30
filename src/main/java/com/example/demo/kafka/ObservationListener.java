package com.example.demo.kafka;



import com.example.demo.dto.OrderDTO;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Component
public class ObservationListener {

    private final OrderService orderService;

    public OrderListener(OrderService orderService) {
        this.orderService = orderService;
    }


    @KafkaListener(topics = )
    public void listen(OrderDTO dto) {
        // 2. Convert entity to DTO
        Order order = OrderMapper.toEntity(dto);
        orderService.saveOrder(order);
        System.out.println("Observation saved: " + order);
    }
}
