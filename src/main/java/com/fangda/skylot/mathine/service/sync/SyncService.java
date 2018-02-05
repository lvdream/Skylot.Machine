package com.fangda.skylot.mathine.service.sync;

import com.fangda.skylot.mathine.utils.exception.SkyLotException;

import java.util.Map;

/**
 * Created by Saul on 16/06/2017.
 */
public interface SyncService {

    /**
     * 心跳同步
     *
     * @return
     */
    int heartbeatSyncServer() throws SkyLotException, Exception;

    /**
     * PLC心跳同步
     *
     * @return
     */
    int heartbeatSyncPLC() throws SkyLotException, Exception;

    /**
     * 停车
     *
     * @param carNumber 车牌
     * @return iStatus:0, 停车成功, 1, 停车失败;iParkingLocation:停车位置;iDirection:待旋转到最下方车位;BaseNumber:操作之前最下方车位编号;iParkingStatus:当前停车状态
     */
    Map parkCar(String carNumber, boolean firstPark) throws SkyLotException, Exception;

    /**
     * 取车指令
     *
     * @return iStatus:0, 停车成功, 1, 停车失败;iParkingLocation:停车位置;iDirection:待旋转到最下方车位;BaseNumber:操作之前最下方车位编号;iParkingStatus:当前停车状态
     */
    Map pullCar(String carNumber) throws SkyLotException, Exception;

    /**
     * 检查车辆是否授权
     *
     * @param carNumber 车牌号
     * @return 0, 车辆已授权, 1, 车辆非经授权
     * @throws Exception
     */
    int checkCarFromDB(String carNumber) throws Exception;

    /**
     * 检查PLC状态
     *
     * @param checkType 检查类型,0,状态检查,1,状态和空闲车位检查,9:心跳检查
     * @param check     是否自动循环
     * @return 0, 检查成功, 1, 检查失败,2,没有空位可以停车
     * @throws Exception
     */
    int checkPLC(int checkType, boolean... check) throws Exception;

    /**
     * 获取待取车的停车位置
     *
     * @param carNumber 车牌
     * @return 0, 没有位置, 其他就是位置信息
     */
    int getParkingPhysicalCode(String carNumber) throws Exception;

    /**
     * 更新同步日程
     *
     * @param scheduleMap
     * @throws Exception
     */
    void updateSchedule(Map scheduleMap) throws Exception;

    /**
     * 创建存取车流程
     *
     * @param carNumber
     * @param parkingMap
     * @param isParking
     * @return
     */
    int createParkinglog(String carNumber, Map parkingMap, int isParking);

    /**
     * 是否同步失败的数据
     *
     * @param errorType   错误的类型
     * @param compareDate 是否要比较时间
     * @return true:是,false:否
     */
    boolean hasSyncError(String errorType, boolean... compareDate) throws Exception;
}
