package com.example.demo;

import com.example.demo.model.Observation;
import com.example.demo.repository.ObservationRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.config.TopicBuilder;

import java.time.Instant;


@RequiredArgsConstructor
@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.model")
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@ComponentScan(basePackages = "com.example.demo")
public class Application {

	private final ObservationRepository observationRepository;


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

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Observation obs = new Observation("temperature", Instant.now(), 23.5, 40.4168, -3.7038);
			observationRepository.save(obs);
			System.out.println("Observation guardada: " + obs);
		};
	}
}
