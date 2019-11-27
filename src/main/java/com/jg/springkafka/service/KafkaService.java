package com.jg.springkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private static final String TOPIC = "Kafka_Example";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message){
        kafkaTemplate.send(TOPIC, message);
    }

    @KafkaListener(topics = "Kafka_Example", groupId = "Kafka_Group")
    public void consumeMessage(String message){
        System.out.println("Received message: " + message);
    }

}
