package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;


@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private String productName;
    private int productQuantity;
    private BigDecimal price;
    private Instant timestamp = Instant.now();

    public Order(Long id, Long customerId, String productName, int productQuantity, BigDecimal price, Instant createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.price = price;
        this.timestamp = createdAt;
    }
}
