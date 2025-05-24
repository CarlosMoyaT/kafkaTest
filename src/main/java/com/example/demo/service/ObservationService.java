package com.example.demo.service;

import com.example.demo.metrics.ObservationMetrics;
import com.example.demo.model.Observation;
import com.example.demo.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {

    private ObservationRepository observationRepository;
    private final ObservationMetrics observationMetrics;

    public ObservationService(ObservationRepository observationRespository, ObservationMetrics observationMetrics) {
        this.observationRepository = observationRespository;
        this.observationMetrics = observationMetrics;
    }

    public void saveObservation(Observation observation) {
        observationRepository.save(observation);

    }

    public List<Observation> getObservationsByType(String type) {
        return observationRepository.findByType(type);

    }

    public List<Observation> getRecentObservations() {
        return observationRepository.findAll();

    }

    public void processLatestObservation() {
        Observation latest = observationRepository.findTopByOrderByTimestampDesc();
        if (latest != null) {
            observationMetrics.updateTemperature(latest.getTemperature());
        }
    }
}
