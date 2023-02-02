package com.yumy.saga.kafka;

import com.yumy.saga.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class JsonKafkaProducer {

    private final KafkaTemplate<String, UserDto> kafkaTemplate;


    public void sendObject(UserDto user) {

        Message<UserDto> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "Users")
                .build();
        kafkaTemplate.send(message);
        log.info("Object is sent {}", user.toString());
    }

}
