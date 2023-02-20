package com.vdk.kafkaTraining.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class SimpleKafkaListener {
    private final List<String> memory = new LinkedList<>();

    @KafkaListener(groupId = "kafkaTraining-1", topics = "my-topic")
    public void listen(String data) {
        memory.add(data);
    }

    public List<String> getMemory() {
        return memory;
    }

}
