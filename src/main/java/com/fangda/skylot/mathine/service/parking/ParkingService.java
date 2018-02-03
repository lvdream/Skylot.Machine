/***********************************************************************
 * Module:  ParkingService.java
 * Author:  saul
 * Purpose: Defines the Interface ParkingService
 ***********************************************************************/

package com.fangda.skylot.mathine.service.parking;

import com.fangda.skylot.mathine.model.parking.TstbMathineParking;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingCriteria;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;

/**
 * 停车主服务接口
 *
 * @pdOid 6e1f8fc9-0e00-46c7-8d76-52d068145f0c
 */
public interface ParkingService extends IBaseService<TstbMathineParking, TstbMathineParkingCriteria> {
    /**
     * 一键取车
     *
     * @param cusId 客户序号
     * @param carId 汽车序号
     * @param maId  设备序号
     * @param key   访问密钥
     * @throws SkyLotException
     * @pdOid a0806399-a21a-47a7-aa1a-b6568b530226
     */
    int easyPullCar(int cusId, int carId, int maId, int key) throws SkyLotException;


}