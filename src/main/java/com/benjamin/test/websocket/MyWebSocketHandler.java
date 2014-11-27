package com.benjamin.test.websocket;

import com.benjamin.websocket.handler.SendIdentityClusterWebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by benjamin on 11/26/14.
 */
public class MyWebSocketHandler extends SendIdentityClusterWebSocketHandler {
  @Override
  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    super.handleMessage(session, message);
    System.out.println("I handle message##########"+message);
  }
}
