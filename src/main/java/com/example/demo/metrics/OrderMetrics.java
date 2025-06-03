package com.example.demo.metrics;

import io.micrometer.core.instrument.*;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class OrderMetrics {

    private final Counter totalOrders;
    private final Counter totalRevenue;
    private final AtomicReference<Double> averageOrderValue = new AtomicReference<>(0.0);
    private final AtomicInteger countOrder = new AtomicInteger(0);

    private final ConcurrentHashMap<String, Counter> produceCounters = new ConcurrentHashMap<>();

    public OrderMetrics(MeterRegistry registry) {
        this.totalOrders = Counter.builder("total_orders")
                .description("Orders processed")
                .register(registry);
        this.totalRevenue = Counter.builder("total_orders_revenue")
                .description("Revenue generated")
                .register(registry);
        Gauge.builder("average_value_orders", averageOrderValue, AtomicReference::get)
                .description("Average value from orders")
                .register(registry);
    }

    public void trackOrder(BigDecimal price, String productName) {
        totalOrders.increment();
        totalRevenue.increment(price.doubleValue());

        int count = countOrder.incrementAndGet();
        double avg = ((averageOrderValue.get() * (count - 1)) + price.doubleValue() / count);

        produceCounters.computeIfAbsent(productName, name ->
                Counter.builder("Orders by product")
                        .description("Orders per product")
                        .tag("product", name)
                        .register(io.micrometer.core.instrument.Metrics.globalRegistry)
        ).increment();

    }
}
