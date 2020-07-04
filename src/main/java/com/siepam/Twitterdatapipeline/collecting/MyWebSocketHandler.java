package com.siepam.Twitterdatapipeline.collecting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class MyWebSocketHandler extends AbstractWebSocketHandler {
    @Override
    public void handleMessage(WebSocketSession session,
                              WebSocketMessage <?> message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = objectMapper.readValue(message.getPayload().toString(), Request.class);
        System.out.println(request.toString());
    }
}
