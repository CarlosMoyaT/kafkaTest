package com.example.demo.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "kafka_messages")
public class KafkaMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String key;
    private String value;

    @CreatedDate
    private String timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }



    public KafkaMessage() {
    }


    @Override
    public String toString() {
        return "KafkaMessage{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
