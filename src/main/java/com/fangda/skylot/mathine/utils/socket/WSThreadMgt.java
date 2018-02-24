package com.fangda.skylot.mathine.utils.socket;

import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 主线程控制类--WebService服务线程控制类
 */
@Slf4j
@Component
public class WSThreadMgt {
    /**
     * 初始化Socket连接池为1
     */
    private BlockingQueue<Map> connection = new ArrayBlockingQueue(1);

    /**
     * 将执行命令放入连接池,阻塞
     *
     * @param map
     */
    public void putCommander(Map map) throws Exception {
        try {
            connection.offer(map, NumberUtils.toLong(GetProperties.getProperties("system.properties", "skylot.plc.thread.timeout")), TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
    }

    /**
     * 检查队列中是否有执行命令
     *
     * @return 0>no,1>yes
     */
    public int checkCommander() {
        try {
            return connection.size();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 查看队列中的对象是否和当前对象相符
     *
     * @return 0>no,1>yes
     */
    public int checkObj(Map obj) {
        try {
            Map inMap = connection.element();
            if (MapUtils.isNotEmpty(inMap) && MapUtils.isNotEmpty(obj) && MapUtils.getString(inMap, "name").equals(MapUtils.getString(obj, "name"))) {
                return 1;
            }
            return connection.size();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获取已经在执行的命令
     *
     * @return 命令名称
     */
    public Map getCommands() throws SkyLotException {
        Map map = null;
        try {
            map = connection.poll(NumberUtils.toInt(GetProperties.getProperties("system.properties", "skylot.plc.thread.timeout")), TimeUnit.SECONDS);//从线程池中拿出一个命令
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return map;
    }
}
