package com.fangda.skylot.mathine.scheduler.springtask;

import com.fangda.skylot.mathine.service.sync.SyncService;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Saul on 16/06/2017.
 */
@Component
@Slf4j
public class SyncParkingLogicServer {
    @Autowired
    private SyncService syncServiceImpl;


    /**
     * 同步后台主方法
     *
     * @throws SkyLotException
     */
    public void run() throws SkyLotException {
        int result = 0;
        try {
            result = syncServiceImpl.heartbeatSyncServer();
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        log.warn(df.format(new Date()) + "********heartbeatSyncServer 任务执行完毕****** 执行结果: " + result);
    }


}
