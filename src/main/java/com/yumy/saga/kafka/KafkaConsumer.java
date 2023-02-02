package com.yumy.saga.kafka;

import com.yumy.saga.dto.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaConsumer {


    @KafkaListener(topics = {"Avengers"}, groupId = "myGroup")
    public void consume(String message) {
        log.info("Message received By Kafka consumer {}", message);
    }


    @KafkaListener(topics = "Users", groupId = "myGroup")
    public void consumeUserObject(UserDto userDto) {
        log.info("User Object is Received {}", userDto.toString());
    }


}
