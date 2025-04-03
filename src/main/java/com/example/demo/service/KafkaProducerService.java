package com.example.demo.service;

import com.example.demo.model.SensorData;
import org.apache.kafka.common.metrics.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "iot_sensors";
    private final KafkaTemplate<String, SensorData> kafkaTemplate;
    private final Random random = new Random();

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, SensorData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void sendSensorData() {
        SensorData data = new SensorData(
                "sensor-" + (random.nextInt(10) + 1),
                15 + (random.nextDouble() * 20),
                30 + (random.nextDouble() * 50)
        );

        kafkaTemplate.send(TOPIC, data);
        System.out.println("Enviado: " + data);
    }
}
