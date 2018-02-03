/***********************************************************************
 * Module:  IndexController.java
 * Author:  saul
 * Purpose: Defines the Class IndexController
 ***********************************************************************/
package com.fangda.skylot.mathine.utils.log;

/**
 * Created by Saul on 11/17/16.
 */


import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * 主页面处理控制器
 *
 * @pdOid aa0967bb-e224-4acc-a823-2660d00a4ac6
 */
@ServerEndpoint("/log")
public class LogController2 {
    private Process process;
    private InputStream inputStream;

    /**
     * 新的WebSocket请求开启
     */
    @OnOpen
    public void onOpen(Session session) {
        try {
            LogHandler view = new LogHandler(session);
            File f = new File("/Users/Saul/Desktop/logs/skylotmachine.log");
            view.realtimeShowLog(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * WebSocket请求关闭
     */
    @OnClose
    public void onClose() {
        try {
            if (inputStream != null)
                inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (process != null)
            process.destroy();
    }

    @OnError
    public void onError(Throwable thr) {
        thr.printStackTrace();
    }
}
