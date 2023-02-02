package com.yumy.saga.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String message) {
        log.info("Message is sent {}", message);
        kafkaTemplate.send("Avengers", message + " WONDERFUL LIFE");
    }

}
