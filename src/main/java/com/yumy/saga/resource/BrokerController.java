package com.yumy.saga.resource;

import com.yumy.saga.dto.UserDto;
import com.yumy.saga.kafka.JsonKafkaProducer;
import com.yumy.saga.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/kafka")
@RequiredArgsConstructor
public class BrokerController {

    private final KafkaProducer kafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    @GetMapping(path = "/publish")
    public ResponseEntity<String> publishMessage(@RequestParam(name = "message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message Is Sent");
    }

    @PostMapping(path = "/publish-object")
    public ResponseEntity<UserDto> publishMessage(@RequestBody UserDto user) {
        jsonKafkaProducer.sendObject(user);
        return ResponseEntity.ok(user);
    }


}
