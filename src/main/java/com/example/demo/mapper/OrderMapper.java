package com.example.demo.mapper;


import com.example.demo.dto.OrderDTO;
import com.example.demo.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class OrderMapper {

    public Order toEntity(OrderDTO dto) {
        return new Order(
                dto.getId(),
                dto.getCustomerId(),
                dto.getProductName(),
                dto.getProductQuantity(),
                dto.getPrice(),
                dto.getTimestamp()
        );
    }
}
