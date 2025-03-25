package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Getter
@Setter
@EnableScheduling
@Configuration
@ConfigurationProperties(prefix = "app.kafka")

//This class is used to bind configuration values from application.yml file to the respective fields
@Component
public class AppConfig {

    private String topicName;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;

    }
}
