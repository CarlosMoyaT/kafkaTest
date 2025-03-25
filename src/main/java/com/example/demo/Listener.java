package com.example.demo;

import com.example.demo.controller.KafkaMessageController;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    private final KafkaMessageController messageController;

    @Autowired
    public Listener(KafkaMessageController messageController) {
        this.messageController = messageController;
    }


    @KafkaListener(topics = "my-topic", groupId = "group1")
    public void consume(ConsumerRecord<String, String> record) {
        String message = "Key: " + record.key() + ", Value: " + record.value();
        System.out.println(message);
        messageController.addMessage(message);
    }
}
