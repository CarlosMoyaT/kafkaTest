package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;


@RequiredArgsConstructor
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



}
