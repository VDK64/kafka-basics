package com.vdk.kafkaTraining.controller;

import com.vdk.kafkaTraining.dto.RequestDto;
import com.vdk.kafkaTraining.dto.ResponseDto;
import com.vdk.kafkaTraining.listeners.SimpleKafkaListener;
import com.vdk.kafkaTraining.writers.SimpleKafkaWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class MainController {

    private final SimpleKafkaWriter writer;
    private final SimpleKafkaListener listener;

    public MainController(SimpleKafkaWriter writer, SimpleKafkaListener listener) {
        this.writer = writer;
        this.listener = listener;
    }


    @GetMapping("message")
    public ResponseEntity<ResponseDto> getMessage() {
        return ResponseEntity.ok(new ResponseDto(listener.getMemory()));
    }

    @PostMapping("write")
    public ResponseEntity<Void> writeMessage(@RequestBody RequestDto requestDto) throws ExecutionException, InterruptedException {
        writer.writeMessage(requestDto.message());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
