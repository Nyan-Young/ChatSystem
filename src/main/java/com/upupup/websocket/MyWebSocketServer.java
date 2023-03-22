package com.upupup.websocket;

import com.alibaba.fastjson.JSONObject;
import com.upupup.utils.Utils;
import com.upupup.websocket.manager.impl.WebSocketManager;
import com.upupup.websocket.server.impl.WebSocketServer;
import org.java_websocket.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.List;

@ServerEndpoint("/websocket/{userId}")
@Component
public class MyWebSocketServer extends WebSocketServer {
    private Logger logger = LoggerFactory.getLogger(com.upupup.websocket.MyWebSocketServer.class);
    @OnMessage
    @Override
    public void getMessage(String message, Session session) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        String id=jsonObject.getString("name");
        String userId=getUserId();
        if(id!=null){
            String type=jsonObject.getString("type");
            String msg="";
            jsonObject.put("name", userId);
            if(type==null){
                msg=jsonObject.getString("message");
            }else if(type.equals("add")){
                msg=id+"你好！我们已经是好友了。";
            }else if(type.equals("delete")){
                msg="您已经被"+userId+"删除好友";
            }
            WebSocketManager.getInstance().sendMessageToOne(id, JSONObject.toJSONString(jsonObject));
            if(!msg.equals("")){
                jsonObject.put("message",msg);
                Utils.appendToFile(id, jsonObject);
                logger.info("收到用户" + userId + "的消息：" + msg);
            }
        }else{
            id=jsonObject.getString("buddy");
            WebSocketManager.getInstance().sendMessageToOne(userId,Utils.readFile(userId,id,jsonObject.getString("num")));
        }
    }
}
