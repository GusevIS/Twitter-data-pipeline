package com.siepam.Collector.collecting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siepam.Collector.collecting.entity.MeetupRSVP;
import com.siepam.Collector.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
@Slf4j
public class MyWebSocketHandler extends AbstractWebSocketHandler {

    private final KafkaProducer producer;

    @Autowired
    MyWebSocketHandler(KafkaProducer producer) {
        this.producer = producer;
    }

    @Override
    public void handleMessage (WebSocketSession session ,
                              WebSocketMessage <?> message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MeetupRSVP meetupRSVP = objectMapper.readValue(message.getPayload().toString(), MeetupRSVP.class);
        ObjectMapper objectMapperSecond = new ObjectMapper();
        String jsonInString = objectMapperSecond.writeValueAsString(meetupRSVP);
        log.info("New RSVP:\n" + jsonInString);
        this.producer.sendMessage(meetupRSVP);
    }
}
