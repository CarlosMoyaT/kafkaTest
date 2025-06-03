package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class OrderDTO {

        private Long id;
        private Long customerId;
        private String productName;
        private int productQuantity;
        private BigDecimal price;
        private Instant timestamp = Instant.now();


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                id = id;
        }

        public Long getCustomerId() {
                return customerId;
        }

        public void setCustomerId(Long customerId) {
                this.customerId = customerId;
        }

        public String getProductName() {
                return productName;
        }

        public void setProductName(String productName) {
                this.productName = productName;
        }

        public int getProductQuantity() {
                return productQuantity;
        }

        public void setProductQuantity(int productQuantity) {
                this.productQuantity = productQuantity;
        }

        public BigDecimal getPrice() {
                return price;
        }

        public void setPrice(BigDecimal price) {
                this.price = price;
        }

        public Instant getTimestamp() {
                return timestamp;
        }

        public void setTimestamp(Instant timestamp) {
                this.timestamp = timestamp;
        }
}
