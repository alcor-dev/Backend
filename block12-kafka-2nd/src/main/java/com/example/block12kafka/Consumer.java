package com.example.block12kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @Autowired
    Producer producer;

    //Here we receive the topic from the other kafka and since we're in the same group we get the info
    @KafkaListener(topics = "bosonit", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println(message);

        //Then we use the producer we autowired before so we can send automatically a response to the
        //message we got since that was the objective of the exercise proposed
        producer.sendMessage("We received your message sir");

    }
}
