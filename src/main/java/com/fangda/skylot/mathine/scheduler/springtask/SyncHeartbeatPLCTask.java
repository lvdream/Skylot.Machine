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
        Map map = Maps.newHashMap();
        map.put("name", "PLC");
        int result = 0;
        try {
            if (wsThreadMgt.checkCommander() == 0) {
                wsThreadMgt.putCommander(map);
                result = syncServiceImpl.heartbeatSyncPLC();
                Map map1 = wsThreadMgt.getCommands();
                if (!map1.get("name").equals("PLC")) {
                    wsThreadMgt.putCommander(map);
                    wsThreadMgt.getCommands();
                }
            }
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
    }
}
