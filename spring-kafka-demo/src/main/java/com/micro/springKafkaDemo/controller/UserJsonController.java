package com.micro.springKafkaDemo.controller;

import com.micro.springKafkaDemo.kafka.KafkaJsonProducer;
import com.micro.springKafkaDemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/createUser")
public class UserJsonController {

    @Autowired
    private KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        kafkaJsonProducer.sendJsonUser(user);
        return ResponseEntity.ok("User created..");
    }
}
