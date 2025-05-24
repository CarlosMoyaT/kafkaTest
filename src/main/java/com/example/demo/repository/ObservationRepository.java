package com.example.demo.repository;

import com.example.demo.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {


    List<Observation> findByType(String type);


    Observation findTopByOrderByTimestampDesc();
}

