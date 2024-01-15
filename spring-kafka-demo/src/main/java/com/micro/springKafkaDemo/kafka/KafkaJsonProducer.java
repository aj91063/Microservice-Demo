package com.micro.springKafkaDemo.kafka;

import com.micro.springKafkaDemo.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    @Value("${simple.topic_json.name}")
    private String topic_json;
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    public void sendJsonUser(User user){
        LOGGER.info(String.format("Message sent -> %s",user.toString()));
        Message<User> userMessage = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,topic_json).build();
        kafkaTemplate.send(userMessage);
    }
}
