package com.example.demo.controller;

import com.example.demo.model.Observation;
import com.example.demo.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/observations")
public class ObservationController {

    @Autowired
    private ObservationRepository observationRepository;

    @GetMapping
    public List<Observation> getAllObservations() {
        return observationRepository.findAll();
    }

    @GetMapping(params = "type")
    public List<Observation> getByType(@RequestParam String type) {
        return observationRepository.findByType(type);
    }


}
