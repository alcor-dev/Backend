package com.example.block12kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class KafkaController {

    private final Producer producer;

    //We use the class KafkaController as a wrapper to put the producer class and use it
    @Autowired
    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    //If we use localhost:8090/publish we can use this to send a message to the other kafka
    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
}
