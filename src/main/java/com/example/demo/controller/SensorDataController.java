package com.example.demo.controller;

import com.example.demo.model.SensorData;
import com.example.demo.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorDataController {

    @Autowired
    private SensorDataRepository repository;

    @GetMapping("/latest")
    public List<SensorData> getLatestSensors() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));
    }
}
