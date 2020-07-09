package com.siepam.Meetupdatastream.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siepam.Meetupdatastream.collecting.MyWebSocketHandler;
import com.siepam.Meetupdatastream.collecting.entity.MeetupRSVP;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class kafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(MyWebSocketHandler.class);

    @KafkaListener(id = "Listener", topics = "${kafka.topicName}", containerFactory = "singleFactory")
    public void consume(MeetupRSVP message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("Consumed: \n" + objectMapper.writeValueAsString(message));
    }
}
