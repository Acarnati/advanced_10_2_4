package com.example.creationbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBinding(Source.class)
public class CreationBookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreationBookServiceApplication.class, args);
    }
}
