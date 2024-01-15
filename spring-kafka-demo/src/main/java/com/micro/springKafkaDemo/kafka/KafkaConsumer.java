package com.micro.springKafkaDemo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${simple.topic.name}")
    public void consumer(String message) {
        LOGGER.info(String.format("Message Consume -> %s", message));
    }
}
