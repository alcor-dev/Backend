package com.example.block12kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String TOPIC = "bosonit";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //This method will send the message we chose from postman so it only gets to the people that
    //is listening to the bosonit topic
    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
