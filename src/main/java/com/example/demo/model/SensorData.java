package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
@Getter
@Setter
public class SensorData {
    private String sensorID;
    private double temperature;
    private double humidity;
    private LocalDateTime timestamp;

    public SensorData(String sensorID, double temperature, double humidity) {
        this.sensorID = sensorID;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = LocalDateTime.now();
    }
}
