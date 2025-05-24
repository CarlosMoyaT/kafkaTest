package com.example.demo.kafka;

import com.example.demo.dto.ObservationDTO;
import com.example.demo.mapper.ObservationMapper;
import com.example.demo.model.Observation;
import com.example.demo.service.ObservationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.example.demo.mapper.ObservationMapper.toEntity;

@Component
public class ObservationListener {

    private final ObservationService observationService;

    public ObservationListener(ObservationService observationService) {
        this.observationService = observationService;
    }


    @KafkaListener(topics = "astro.observations", groupId = "observation-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(ObservationDTO dto) {
        // 2. Convert entity to DTO
        Observation observation = ObservationMapper.toEntity(dto);
        observationService.saveObservation(observation);
        System.out.println("Observation saved: " + observation);
    }
}
