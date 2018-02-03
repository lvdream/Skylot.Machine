package com.fangda.skylot.mathine.utils.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 主线程控制类
 */
@Slf4j
@Component
public class ThreadMgt {
    /**
     * 初始化Socket连接池为1
     */
    private BlockingQueue<Socket> connection = new ArrayBlockingQueue(1);

    /**
     * 将执行命令放入连接池
     *
     * @param socket
     */
    public void putCommander(Socket socket) {
        try {
            connection.put(socket);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.warn("当前命令已经成功放入线程池,等待执行完毕");
    }

    /**
     * 获取已经在执行的命令
     *
     * @return 命令名称
     */
    public Socket getCommands() {
        Socket action = null;
        try {
            action = connection.poll(1, TimeUnit.SECONDS);//从线程池中拿出一个命令
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (action != null) {
            log.warn("最后一条命令已经成功取出");
        } else {
            log.warn("命令池没有存放的命令");
        }
       return action;
    }

}
