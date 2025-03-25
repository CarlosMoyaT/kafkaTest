package com.example.demo.Producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class MyKafkaProducer {


    private final KafkaTemplate<String, String> kafkaTemplate;


    public MyKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        try {
            kafkaTemplate.send(topic, key, value).get();
            System.out.println("Message send success: " + value);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error send message: " + e.getMessage());
        }
    }

    @Scheduled(fixedRate = 5000)
    public void sendAutoMessage() {
        kafkaTemplate.send("my-topic", "key-" + System.currentTimeMillis(), "automatic message");
        System.out.println("Auto message send to kafka");
    }

    public void sendMessagesInLoop(String topic) {
        for (int i = 0; i < 100; i++) {
            sendMessage(topic, "key-" + i, "Message number " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
