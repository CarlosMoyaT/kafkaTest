package com.example.demo.kafka;



import com.example.demo.model.Order;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;


@Service
@RequiredArgsConstructor
public class KafkaOrderProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaOrderProducer.class);
    private final KafkaTemplate<String, Order> orderKafkaTemplate;
    private static final String TOPIC = "realtime_orders";

    private final Random rnd = new Random();
    private final AtomicLong customerIdGenerator = new AtomicLong(1);

    private final String[] products = {"laptop", "Smartphone", "Tablet", "Keyboard", "Monitor"};

    public KafkaOrderProducer(KafkaTemplate<String, Order> orderKafkaTemplate) {
        this.orderKafkaTemplate = orderKafkaTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void produceRandomOrder() {
        Order order = generateRamdomOrder();
        orderKafkaTemplate.send(TOPIC, order);
        logger.info("Order sended to kafka: {}", order);
    }

    private Order generateRamdomOrder() {
        long customerId = customerIdGenerator.getAndIncrement();
        String productName = products[rnd.nextInt(products.length)];
        int quantity = 1 + rnd.nextInt(5);
        BigDecimal price = BigDecimal.valueOf(50 + rnd.nextInt(900));
        return new Order(null, customerId, productName, quantity, price, Instant.now());
    }

}
