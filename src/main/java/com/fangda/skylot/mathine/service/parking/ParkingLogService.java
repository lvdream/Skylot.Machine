/***********************************************************************
 * Module:  ParkingService.java
 * Author:  saul
 * Purpose: Defines the Interface ParkingService
 ***********************************************************************/

package com.fangda.skylot.mathine.service.parking;

import com.fangda.skylot.mathine.model.parking.TstbMathineParkingLog;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingLogCriteria;
import com.fangda.skylot.mathine.service.IBaseService;

import java.util.Map;

/**
 * 停车日志服务接口
 *
 * @pdOid 6e1f8fc9-0e00-46c7-8d76-52d068145f0c
 */
public interface ParkingLogService extends IBaseService<TstbMathineParkingLog, TstbMathineParkingLogCriteria> {

    /**
     * 针对回调方式,处理停车
     *
     * @param map 回调转入的停车
     * @return 状态0:成功,1:失败
     */
    int parkingFromCallbak(Map map) throws Exception;


    /**
     * 主停车方法
     *
     * @param parkingCar 待停车车牌
     * @param firstPark 是否是首次停车吗,true is 是
     * @return 0, 操作成功, 1, 有车正在进行停车, 2, 故障或者异常
     * @throws Exception
     */
    int parkingAction(String parkingCar, boolean firstPark) throws Exception;

    /**
     * 处理消息的显示
     *
     * @param statusMap 状态Map
     * @param action    操作类型
     * @return StringBuilder
     */
    StringBuilder layoutMessage(Map statusMap, String action);
}