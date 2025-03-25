package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;

public class Listener {


    //message with key
    @KafkaListener(topics = "myTopickey", groupId = "groupKey")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.printf("Key: %s, Value: %s, Partition: %d, Offset: %d%n",
                record.key(), record.value(), record.partition(), record.offset());
    }
}
