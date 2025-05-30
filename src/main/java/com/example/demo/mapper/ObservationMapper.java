package com.example.demo.mapper;


import com.example.demo.dto.OrderDTO;
import com.example.demo.model.Observation;


import java.time.Instant;

public class ObservationMapper {

    public static Observation toEntity(OrderDTO dto) {
        return new Observation(
                dto.getType(),
                Instant.parse(dto.getTimestamp()),
                dto.getTemperature(),
                dto.getLatitude(),
                dto.getLongitude()
        );
    }
}
