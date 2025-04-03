package com.example.demo.repository;

import com.example.demo.model.KafkaMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface KafkaMessageRepository extends JpaRepository<KafkaMessage, String> {

    List<KafkaMessage> findByKey(String key);
    List<KafkaMessage> findByTimestamp(String timestamp);


}
