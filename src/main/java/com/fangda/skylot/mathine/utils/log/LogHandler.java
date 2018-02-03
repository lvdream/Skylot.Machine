package com.fangda.skylot.mathine.utils.log;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.Session;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LogHandler {
    private long lastTimeFileSize = 0;
    private Session session;

    public LogHandler(Session session) {
        this.session = session;
    }

    /**
     * å®žæ—¶è¾“å‡ºæ—¥å¿—ä¿¡æ¯
     *
     * @param logFile æ—¥å¿—æ–‡ä»¶
     * @throws IOException
     */
    public void realtimeShowLog(File logFile) throws IOException {
        final RandomAccessFile randomFile = new RandomAccessFile(logFile, "r");
        ScheduledExecutorService exec =
                Executors.newScheduledThreadPool(1);
        exec.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                try {
                    randomFile.seek(lastTimeFileSize);
                    String tmp = "";
                    while ((tmp = randomFile.readLine()) != null) {
                        session.getBasicRemote().sendText(new String(tmp.getBytes("ISO8859-1")));
                    }
                    lastTimeFileSize = randomFile.length();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}