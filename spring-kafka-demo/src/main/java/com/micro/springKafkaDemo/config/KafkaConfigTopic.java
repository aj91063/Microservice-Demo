package com.micro.springKafkaDemo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfigTopic {

    @Value("${simple.topic.name}")
    private String topic;
    @Value("${simple.topic_json.name}")
    private String topic_json;
    @Bean
    public NewTopic messageTopic(){
        return TopicBuilder.name(topic).build();
    }

    @Bean
    public NewTopic jsonTopic(){
        return TopicBuilder.name(topic_json).build();
    }
}
