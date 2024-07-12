package org.xiao.ns.server;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
import org.xiao.cs.common.box.utils.JsonUtils;
import org.xiao.ns.domain.Body;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/message/{id}/{name}")
public class MessageServer {

    public static final ConcurrentHashMap<String, Session> sessionPool = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("id") String id, @PathParam("name") String name) {
        System.out.println("[Open] ID: " + id + ", Name: " + name);
        sessionPool.put(id, session);
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        Body receive = JsonUtils.toBean(message, Body.class);
        receive.setTimestamp(LocalDateTime.now());
        String sending = JsonUtils.toString(message);
        sessionPool.get(receive.getTarget()).getBasicRemote().sendText(sending);
    }


    @OnClose
    public void onClose(Session session, @PathParam("id") String id, @PathParam("name") String name) {
        System.out.println("[Close] ID: " + id + ", Name: " + name);
        sessionPool.remove(id);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("[Error] : " + error.getMessage());
    }
}
