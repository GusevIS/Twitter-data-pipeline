package com.siepam.Meetupdatastream.collecting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siepam.Meetupdatastream.collecting.entity.MeetupRSVP;
import com.siepam.Meetupdatastream.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
@Slf4j
public class MyWebSocketHandler extends AbstractWebSocketHandler {
    private static final Logger log = LoggerFactory.getLogger(MyWebSocketHandler.class);

    private final KafkaProducer producer;

    @Autowired
    MyWebSocketHandler(KafkaProducer producer) {
        this.producer = producer;
    }

    @Override
    public void handleMessage(WebSocketSession session,
                              WebSocketMessage <?> message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MeetupRSVP meetupRSVP = objectMapper.readValue(message.getPayload().toString(), MeetupRSVP.class);
        log.info("Produced: \n" + meetupRSVP.toString());
        this.producer.sendMessage(meetupRSVP);
    }
}
