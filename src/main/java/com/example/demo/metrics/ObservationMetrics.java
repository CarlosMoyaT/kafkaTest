package com.example.demo.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class ObservationMetrics {

    private final MeterRegistry meterRegistry;
    private final AtomicReference<Double> temperatureGauge = new AtomicReference<>(0.0);

    public ObservationMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        Gauge.builder("temperature", temperatureGauge, AtomicReference::get)
                .description("Current temperature")
                .register(meterRegistry);

    }

    public void updateTemperature(double temperature) {
        temperatureGauge.set(temperature);
    }
}
