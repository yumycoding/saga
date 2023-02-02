package com.yumy.saga.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic someTopic() {
        return TopicBuilder.name("Avengers").build();
    }

    @Bean
    public NewTopic userObjectTopic() {
        return TopicBuilder.name("Users").build();
    }
}
