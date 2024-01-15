package com.micro.springKafkaDemo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

   // @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${simple.topic.name}")
    private String topic;
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message Produce> %s", message));
        kafkaTemplate.send(topic,message);
    }
}
