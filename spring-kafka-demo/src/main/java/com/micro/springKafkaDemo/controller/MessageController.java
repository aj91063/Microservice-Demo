package com.micro.springKafkaDemo.controller;

import com.micro.springKafkaDemo.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/message")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping
    public ResponseEntity<String> sendMessage(
           @RequestParam(name = "message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent...");
    }
}
