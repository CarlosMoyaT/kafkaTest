package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@RequiredArgsConstructor
@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.model")
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@ComponentScan(basePackages = "com.example.demo")
public class Application {



    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public NewTopic myTopic() {
		return TopicBuilder.name("my-topic")
				.partitions(1)
				.replicas(1)
				.build();
	}


}
