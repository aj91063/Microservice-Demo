package com.micro.springKafkaDemo.kafka;

import com.micro.springKafkaDemo.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${simple.topic_json.name}")
    public void consumer(User user){
        LOGGER.info(String.format("Message Consume> %s", user.toString()));
    }
}
