package com.fangda.skylot.mathine.utils.socket;

import com.fangda.skylot.mathine.model.utils.IftbScheduleAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 主线程控制类--WebService服务线程控制类
 */
@Slf4j
@Component
public class WSThreadMgtSend {
    /**
     * 初始化Socket连接池为1
     */
    private BlockingQueue<IftbScheduleAction> connection = new ArrayBlockingQueue(1);

    /**
     * 将执行命令放入连接池
     *
     * @param map
     */
    public void putCommander(IftbScheduleAction map) throws Exception {
        try {
            connection.put(map);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获取已经在执行的命令
     *
     * @return 命令名称
     */
    public IftbScheduleAction getCommands() {
        IftbScheduleAction map = null;
        try {
            map = connection.poll(1, TimeUnit.SECONDS);//从线程池中拿出一个命令
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (map != null) {
        } else {
        }
        return map;
    }
}
