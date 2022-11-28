package com.example.block12kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    //Here we define the other way of the message by using a different topic through the same group
    //By using the kafka2nd, we make sure we don't get any info we don't want
    private static final String TOPIC = "kafka2nd";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    //Then we assign a the new topic to the producer coming from this half, so it can send messages
    //in the kafka2nd channel
    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
