package com.micro.emailService;

import com.micro.baseDomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerKafka {
        private static final Logger LOGGER= LoggerFactory.getLogger(OrderConsumerKafka.class);

        private KafkaTemplate<String, OrderEvent> kafkaTemplate;

        @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
        public void consume(OrderEvent orderEvent){
                LOGGER.info(String.format("Order Event Consume => %s",orderEvent));
        }


}
