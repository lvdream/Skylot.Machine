package com.fangda.skylot.mathine.scheduler.springtask;

import com.fangda.skylot.mathine.service.sync.SyncService;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.socket.WSThreadMgt;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 心跳同步类,进行PLC心跳同步,每个10秒运行一次
 * Created by damon on 2016/12/30.
 */
@Component("syncHeartbeatPLCTask")
@Slf4j
public class SyncHeartbeatPLCTask {
    @Autowired
    private SyncService syncServiceImpl;
    @Autowired
    private WSThreadMgt wsThreadMgt;

    public void syncPLC() throws SkyLotException {
        int result = 0;
        try {
            if (wsThreadMgt.checkCommander() == 0) {
                Map map = Maps.newHashMap();
                map.put("name", "PLC");
                wsThreadMgt.putCommander(map);
                result = syncServiceImpl.heartbeatSyncPLC();
                wsThreadMgt.getCommands();
            }
        } catch (Exception e) {
            wsThreadMgt.getCommands();
            throw new SkyLotException(e);
        }
    }
}
