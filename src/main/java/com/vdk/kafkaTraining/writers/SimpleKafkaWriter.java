package com.vdk.kafkaTraining.writers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class SimpleKafkaWriter {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SimpleKafkaWriter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void writeMessage(String message) throws ExecutionException, InterruptedException {
        kafkaTemplate.send("my-topic", message).get();
    }

}
