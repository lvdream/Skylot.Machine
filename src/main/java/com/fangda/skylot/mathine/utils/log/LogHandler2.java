package com.fangda.skylot.mathine.utils.log;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
public class LogHandler2 extends Thread {

    private BufferedReader reader;
    private Session session;
    private String li;

    public LogHandler2(InputStream in, Session session) {
        this.reader = new BufferedReader(new InputStreamReader(in));
        this.session = session;

    }

    public LogHandler2(String in, Session session) {
        this.session = session;
        this.li = in;

    }

    @Override
    public void run() {
        String line;
        try {
            session.getBasicRemote().sendText(li + "<br>");
//            while((line = reader.readLine()) != null) {
//                // 将实时日志通过WebSocket发送给客户端，给每一行添加一个HTML换行
//                session.getBasicRemote().sendText(line + "<br>");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
