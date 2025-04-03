package com.example.demo.consumer;

import com.example.demo.model.KafkaMessage;
import com.example.demo.repository.KafkaMessageRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class Listener {




    @KafkaListener(topics = "my-topic", groupId = "group1")
    public void consume(ConsumerRecord<String, String> record) {
        String message = "Key: " + record.key() + ", Value: " + record.value();

        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setKey(record.key());
        kafkaMessage.setValue(record.value());
        kafkaMessage.setTimestamp(Instant.now().toString());

        System.out.println(message);
    }
}


