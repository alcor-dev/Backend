package com.example.block12kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//This class creates a consumer that gets the Producer request from other places
//Important to keep control over the annotation
@Service
public class Consumer {

    //Here, the topic defines the place where you'll receive the info, like a channel
    //Group works as a major filtering thing
    @KafkaListener(topics = "kafka2nd", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println(message);

    }
}
