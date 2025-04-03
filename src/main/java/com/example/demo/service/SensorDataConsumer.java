package com.example.demo.service;

import com.example.demo.model.SensorData;
import com.example.demo.repository.SensorDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class SensorDataConsumer {

    @Autowired
    private SensorDataRepository repository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "iot_sensors", groupId = "sensor-group")
    public void consume(String message) {
        try {
            SensorData data = objectMapper.readValue(message, SensorData.class);
            repository.save(data);
            System.out.println("save on DB: " + data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
