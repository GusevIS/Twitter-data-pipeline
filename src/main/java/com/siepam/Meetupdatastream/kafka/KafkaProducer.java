package com.siepam.Meetupdatastream.kafka;

import com.siepam.Meetupdatastream.collecting.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Value(value = "${kafka.topicName}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Request> kafkaTemplate;

    public void sendMessage(Request message) {
        this.kafkaTemplate.send(topicName, message);
    }
}
